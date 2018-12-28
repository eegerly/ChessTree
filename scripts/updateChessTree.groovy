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
import ChessTree.OddsView
import ChessTree.ConnectorView



/*************/
/** Globals **/
/*************/
cts = new ChessTreeSettings(this.node.map)

DICTIONARY = cts.DICTIONARY

ROOT = this.node.map.root
LANGUAGE_CURRENT = cts.get("chesstree_language")
NUMBERING_CURRENT = cts.get("chesstree_numbering")
NAG_CURRENT = cts.get("chesstree_NAG")
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
    def connector_next = cts.SUPPORTED_CONNECTOR.find{it.value == vars["chesstree_connectors"].getSelectedItem()}.key
    def odds_next = cts.SUPPORTED_ODDS.find{it.value == vars["chesstree_odds"].getSelectedItem()}.key

    if ((LANGUAGE_CURRENT != language_next) || (NUMBERING_CURRENT != numbering_next)) {
        // notation text modification is needed
        updateNotation(language_next, numbering_next)
    }
    
    if (NAG_CURRENT != NAG_next) {
        // TODO: updateDetails(hide/show)...
    }
    
    if (ODDS_CURRENT != odds_next) {
        oddsView = new OddsView(this.node.map)
        oddsView.updateCharts(odds_next=="show")
    }
    if (CONNECTOR_CURRENT != connector_next) {
        connectorView = new ConnectorView(this.node.map)
        connectorView.updateConnectors(connector_next=="freq")
    }
    
    
    /* Update properties */
    saveSettings(vars)
}

if (vars.dialogResult == 'save') {
    saveSettings(vars)
}
return 0

/*************/
/* Functions */
/*************/
def saveSettings(vars) {
    cts.getSupportedProperties().each{
        def value = ""
        value = vars[it].getSelectedItem()
        cts.setByValue(it, value)
    }
    this.node.map.save(true) // true: allow interaction
}


def getNodePlyNumber(node) {
    def a = node
    // search for FEN
    def plyCount = 0
    while (!a.attributes.containsKey("FEN")) {
        a=a.parent; plyCount++;
        if (a==null) return -1;
    }
        
    def m = (a["FEN"] =~ /(?msu).* ([bw]) .* \d+ (\d+)/)

    if (m.size()==0) return -1
    else {    
        def moveNumber_afterSP = m[0][2].toInteger()
        def next_afterSP = m[0][1]
        def plyCount_afterSP = moveNumber_afterSP*2-1 + (next_afterSP=="w"?0:1)
        
        return plyCount_afterSP + plyCount - 1
    }
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

