import org.freeplane.features.map.MapModel;
import org.freeplane.features.attribute.AttributeRegistry;
import org.freeplane.features.attribute.AttributeRegistryElement;

import org.freeplane.plugin.script.proxy.ScriptUtils
import groovy.swing.SwingBuilder
import java.awt.FlowLayout as FL
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Action;

import javax.swing.BoxLayout as BXL
import javax.swing.JFrame
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import groovy.transform.Field

import ChessTree.Notation
import ChessTree.NotationTranslator
import ChessTree.ChessTreeSettings

/*************/
/** Globals **/
/*************/
cts = new ChessTreeSettings(this.node.map)

DICTIONARY = cts.DICTIONARY

ROOT = this.node.map.root

LANGUAGE_CURRENT = cts.get("chesstree_language")
NUMBERING_CURRENT = cts.get("chesstree_numbering")
NAG_CURRENT = cts.get("chesstree_NAG")
ROOT_MOVENUMBER_CURRENT = cts.get("chesstree_root_movenumber").toInteger()
CONNECTOR_CURRENT = cts.get("chesstree_connectors")
ODDS_CURRENT = cts.get("chesstree_odds")

/* Globals for odds image updater */ 
mapfile=this.node.map.file
mapfilePath = mapfile.parent.replace("\\", "/")
mapfileName = mapfile.name.lastIndexOf('.').with {it != -1 ? mapfile.name[0..<it] : mapfile.name}
imgAbsPath = mapfilePath + "/img_" + mapfileName
imgRelPath = "./img_" + mapfileName



/*****************/
/**** Settings ***/ 
/*****************/

/* Build Dialog window */
def s = new SwingBuilder()
s.setVariable('myDialog-properties',[:])
def vars = s.variables
def disableItem(item) {item.enabled = !item.enabled}
def dial = s.dialog(title:"ChessTree settings...", id:'myDialog', modal:true, 
            locationRelativeTo:ui.frame, owner:ui.frame, defaultCloseOperation:JFrame.DISPOSE_ON_CLOSE, 
            preferredSize: [280, 300], pack:true, show:true) {
    panel(id:'pMain') {
        boxLayout(axis:BXL.Y_AXIS)
        /* 
        Text: Current language is ___. Check tooltip if you don't agree. 
        Tooltip: If the language of notation in the mindmap is inconsistent you should edit the mindmap manually to make its language consistent. 
        Otherwise change below settings and click on "Save". It affects settings saved in Mindmap properties, Mindmap content will not change. 
        */
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Language', preferredSize: [120, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'chesstree_language', preferredSize: [100, 24], editable:true,
				items:cts.SUPPORTED_LANGUAGES.collect{it.value}, selectedItem:cts.SUPPORTED_LANGUAGES[LANGUAGE_CURRENT]) 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Numbering', preferredSize: [120, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'chesstree_numbering', preferredSize: [100, 24], editable:true,
				items:cts.SUPPORTED_NUMBERING.collect{it.value}, selectedItem:cts.SUPPORTED_NUMBERING[NUMBERING_CURRENT]) 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('NAG', preferredSize: [120, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'chesstree_NAG', preferredSize: [100, 24], editable:true,
				items:cts.SUPPORTED_NAG.collect{it.value}, selectedItem:cts.SUPPORTED_NAG[NAG_CURRENT]) 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Root move number', preferredSize: [120, 24], mouseClicked:{disableItem(guiCategory)})
            spinner(id:'chesstree_root_movenumber',
                model:spinnerNumberModel(minimum:1, maximum: 100, stepSize:1, value:ROOT_MOVENUMBER_CURRENT ))
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Connectors', preferredSize: [120, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'chesstree_connectors', preferredSize: [100, 24], editable:true,
				items:cts.SUPPORTED_CONNECTOR.collect{it.value}, selectedItem:cts.SUPPORTED_CONNECTOR[CONNECTOR_CURRENT]) 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Odds', preferredSize: [120, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'chesstree_odds', preferredSize: [100, 24], editable:true,
				items:cts.SUPPORTED_ODDS.collect{it.value}, selectedItem:cts.SUPPORTED_ODDS[ODDS_CURRENT]) 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            button('Save & Apply', preferredSize:[120, 24],
                   actionPerformed:{
                       vars.dialogResult = 'save&apply'
                       dispose()
            })
            button('Save', preferredSize:[120, 24],
                   actionPerformed:{
                       vars.dialogResult = 'save'
                       dispose()
            })
        }
        panel(alignmentX:0f) {
            button('Cancel', preferredSize:[120, 24],
                   actionPerformed:{
                       vars.dialogResult = 'cancel'
                       dispose()
            })
        }
    }
}


/*************/
/**** Main ***/ 
/*************/
logger.createLogger() 


if (vars.dialogResult == 'save&apply') {
    /* Handle received data */

    def language_next = cts.SUPPORTED_LANGUAGES.find{it.value == vars["chesstree_language"].getSelectedItem()}.key
    def numbering_next = cts.SUPPORTED_NUMBERING.find{it.value == vars["chesstree_numbering"].getSelectedItem()}.key
    def NAG_next = cts.SUPPORTED_NAG.find{it.value == vars["chesstree_NAG"].getSelectedItem()}.key
    def root_movenumber_next = vars["chesstree_root_movenumber"].getValue()
    def connector_next = cts.SUPPORTED_CONNECTOR.find{it.value == vars["chesstree_connectors"].getSelectedItem()}.key
    def odds_next = cts.SUPPORTED_ODDS.find{it.value == vars["chesstree_odds"].getSelectedItem()}.key

    if ((LANGUAGE_CURRENT != language_next) || (NUMBERING_CURRENT != numbering_next)) {
        // notation text modification is needed
        updateNotation(language_next, numbering_next)
    }
    if (ROOT_MOVENUMBER_CURRENT != root_movenumber_next) {
        // TODO: update Notation...
    }
    
    if (NAG_CURRENT != NAG_next) {
        // TODO: updateDetails(hide/show)...
    }
    
    if (ODDS_CURRENT != odds_next) {
        oddsView = new OddsView(this.node.map)
        oddsView.updateCharts()
    }
    if (CONNECTOR_CURRENT != connector_next) {
        connectorView = new ConnectorView(this.node.map)
        ConnectorView.updateConnectors()
    }
    
    
    /* Update properties */
    saveSettings(vars)        
}

if (vars.dialogResult == 'save') {
    saveSettings(vars)
}


/*************/
/* Functions */
/*************/
def saveSettings(vars) {
    cts.getSupportedProperties().each{
        def value = ""
        if (it == "chesstree_root_movenumber") {
            value = vars[it].getValue().toString()
        } else {
            value = vars[it].getSelectedItem()
        }
        cts.setByValue(it, value)
    }
    this.node.map.save(true) // true: allow interaction
}


def getNodePlyNumber(node) {
    return node.getNodeLevel(true) + ROOT_MOVENUMBER*2 - 1 
    // true : countHidden
}

def updateNotation(language_next, numbering_next) {
    def translator = new NotationTranslator(DICTIONARY, cts.SUPPORTED_LANGUAGES)
    /* Translate each node */
    c.findAllDepthFirst().findAll{it.hasStyle("White moves") || it.hasStyle("Black moves")}.each {aNode->
        def text = aNode.getDisplayedText()
        if ((text != null) && (text != "")) {
            translator.setNotation(text, getNodePlyNumber(aNode)) 
        }
        text = "<html><body>"
        if (NUMBERING_CURRENT != numbering_next) {
            if ((numbering_next == "white") && aNode.hasStyle("White moves")) {
                text += """<p><font size="1">${translator.getNotation().getNumbering()}</font></p>"""
            } else if (numbering_next == "both") {
                text += """<p><font size="1">${translator.getNotation().getNumbering()}</font></p>"""
            } else { // "Black moves" and "white", or "none"
                // nothing to do 
            }
        }
        if (LANGUAGE_CURRENT != language_next) {
            text += """<p>${translator.translate(LANGUAGE_CURRENT, language_next)}</p>""" // pure notation without numbering
        } else {
            text += """<p>${translator.getNotation().getMove()}</p>"""
        }
        text += "</body></html>"
        aNode.setText(text)
    }
}


class OddsView {
    private nodeList
    private ROOT
    private mapfile
    private mapfilePath
    private mapfileName
    private imgAbsPath
    private imgRelPath

    def OddsView(map) {
        /* Setting up internal constants */
        ROOT = map.root
        mapfile=map.file
        mapfilePath = mapfile.parent.replace("\\", "/")
        mapfileName = mapfile.name.lastIndexOf('.').with {it != -1 ? mapfile.name[0..<it] : mapfile.name}
        imgAbsPath = mapfilePath + "/img_" + mapfileName
        imgRelPath = "./img_" + mapfileName
        dir = new File(imgAbsPath)
        if (!dir.exists()) {
            dir.mkdir()
        }    
    }
    def updateCharts() {
        ROOT.findAllDepthFirst().each {
            aNode = it    
            /* Update pie chart for winning odds based on ["Odds"] */
            if (aNode.attributes.containsKey("Odds")) {
                if (!(aNode.children.findAll{it.style.name=="Explanation"}?.collect{it.getHtmlText()}[0]?.contains("<img"))) {
                    /* ["Odds"] order: white, black, draw*/
                    updateOddsPieChart(aNode)
                }
            }
        }    
    }
    /*
    Google chart API:
    https://developers.google.com/chart/image/docs/gallery/pie_charts#gcharts_chart_margins
    */
    private updateOddsPieChart(aNode) {
        /* ["Odds"] order: white, black, draw*/
        odds=aNode["Odds"].split(",")
       
        chartData=odds.reverse().join(",") /* chartData order: draw, black, white*/
       
        chartLabels = "|" + odds.reverse()[1..2].join("|") // only white and black
        // chartLabels = odds.reverse().join("|")
        chartRotation =  -Math.PI * ( 0.5  + odds[2].toFloat()/100.0)
       
        chartURL = """https://chart.googleapis.com/chart""" +
                """?chs=120x50&cht=p""" +
                """&chd=t:${chartData}""" +
                """&chl=${chartLabels}""" +
                """&chco=555555|000000|DDDDDD""" +
                """&chp=${chartRotation}""" +
                //"""&chdlp=b|2,1&chdl=${chartLabels}""" +
                """&chma=0,0,0,0|0,0""" +
                """"""
        // println chartURL
       
        oddsFileAbs = "${imgAbsPath}/odds_${aNode.id}.png"
        oddsFileRel = "${imgRelPath}/odds_${aNode.id}.png"
        file = new File(oddsFileAbs).newOutputStream() 
        file << new URL(chartURL).openStream()
        file.close()
       
        aExplanation = aNode.createChild()
        aExplanation.style.setName("Explanation")
        aExplanation.text="""<html><body>
        <img src="${oddsFileRel}">
        </body></html>"""
        aExplanation.setFree(true)
    }        
}

import org.freeplane.features.link.ConnectorModel
class ConnectorView {
    private final MAXWIDTH = 15
    private final HSHIFT_LIMIT = -50
    /* Errors */
    private errors = []
    private final E_ACCESS_METHOD_GETCONNECTOR = 1
    private ROOT
    
    def ConnectorView(map){
        ROOT = map.root
    }
    
    def updateConnectors() {
        ROOT.findAllDepthFirst().each {
            aNode = it    
            /* Update edge based on ["Freq"] */
            if (aNode.attributes.containsKey("Freq")) {
                updateEdge(aNode);
            }

            /* Change edge to connector for "(un)wrapped" nodes (with negative (positive) horizontal shift) 
            with "*moves" style */
            updateNodeConnector(aNode)
        }
    }


    private updateEdge(aNode) {
        width = 0
        if (aNode.parent != null) { // not the root 
            width = (aNode["Freq"].toFloat()*MAXWIDTH/100.0).toInteger()
        }
        aNode.style.edge.setWidth(width)
        //println aNode.style.edge.getModel().getDash()
    }



    private updateNodeConnector(aNode) {
        hasConnectorFromParent = aNode.connectorsIn.collect{it.getSource().id == aNode.parent.id}.inject(false){a,b->a||b}
        hasHiddenEdgeFromParent = aNode.style.edge.type == org.freeplane.features.edge.EdgeStyle.EDGESTYLE_HIDDEN
        hasMovesStyle = (aNode.hasStyle("White moves") || aNode.hasStyle("Black moves"))
        hasNegativeHShift = (aNode.getHorizontalShift() < HSHIFT_LIMIT)
        
        if (hasNegativeHShift && hasMovesStyle && (!hasHiddenEdgeFromParent || !hasConnectorFromParent)) {
            aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {
                aNode.removeConnector(it)
            }
            
            conn = aNode.parent.addConnectorTo(aNode)

            conn.setShape("CUBIC_CURVE")
            conn.setColor(aNode.style.edge.color)
            conn.setStartArrow(false)
            conn.setEndArrow(false)
            
            def ConnectorModel connModel = null
            try {
                connModel = conn.getConnector()
                if (connModel!=null) {
                    connModel.setWidth(aNode.style.edge.width)
                    connModel.setAlpha(255)
                
                }
            } catch (e) {
                //getConnector cannot be accessed...
            }
            vShift = (aNode.getVerticalShift() + aNode.style.getMinNodeWidth())>>1
            //aNode.children[0].findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.each{if (it.getVerticalShift()) println it.getVerticalShift()}
            vShiftOffset = aNode.children[0].findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.collect{it.getVerticalShift()}.sum() // children at the topmost position
            vShiftOffset = (vShiftOffset == null) ? 0:vShiftOffset
            conn.setInclination([0, vShift-vShiftOffset], [-2*vShiftOffset, -vShift-vShiftOffset])
            aNode.style.edge.type = org.freeplane.features.edge.EdgeStyle.EDGESTYLE_HIDDEN    
        }
        if (!hasNegativeHShift && hasMovesStyle && (hasHiddenEdgeFromParent || hasConnectorFromParent)) {
            //aNode.style.name=null
            aNode.style.edge.type= null
            aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {
                aNode.removeConnector(it)
            }        
        }
    }
        
    
}
