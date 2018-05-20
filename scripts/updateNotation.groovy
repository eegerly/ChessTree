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
chessTreeSettings = new ChessTreeSettings(this.node.map)

SUPPORTED_NUMBERING = chessTreeSettings.SUPPORTED_NUMBERING

SUPPORTED_LANGUAGES = chessTreeSettings.SUPPORTED_LANGUAGES

DICTIONARY = chessTreeSettings.DICTIONARY

ROOT = this.node.map.root
ROOT_MOVENUMBER = chessTreeSettings.getProperty("chesstree_root_movenumber").toInteger()

LANGUAGE_CURRENT = chessTreeSettings.getProperty("chesstree_language")

// Supported language for translation
SUPPORTED_LANGUAGES.remove(LANGUAGE_CURRENT)

/*****************/
/**** Settings ***/ 
/*****************/

/* Build Dialog window */
def s = new SwingBuilder()
s.setVariable('myDialog-properties',[:])
def vars = s.variables
def disableItem(item) {item.enabled = !item.enabled}
def dial = s.dialog(title:"Settings for updating notation", id:'myDialog', modal:true, 
            locationRelativeTo:ui.frame, owner:ui.frame, defaultCloseOperation:JFrame.DISPOSE_ON_CLOSE, 
            preferredSize: [280, 180], pack:true, show:true) {
    panel(id:'pMain') {
        boxLayout(axis:BXL.Y_AXIS)
        /* 
        Text: Current language is ___. Check tooltip if you don't agree. 
        Tooltip: If the language of notation in the mindmap is inconsistent you should edit the mindmap manually to make its language consistent. 
        Otherwise change below settings and click on "Change settings". It affects settings saved in Mindmap properties, Mindmap content will not change. 
        */
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Language', preferredSize: [60, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'guiLanguage', preferredSize: [100, 24], editable:true,
				items:SUPPORTED_LANGUAGES.collect{it.value}, /*selectedItem:"Symbolic" */) 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Numbering', preferredSize: [60, 24], mouseClicked:{disableItem(guiCategory)})
			comboBox(id: 'guiNumbering', preferredSize: [100, 24], editable:true,
				items:SUPPORTED_NUMBERING, selectedItem:"None") 
        }  		
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            button('Translate', preferredSize:[120, 24],
                   actionPerformed:{
                       vars.dialogResult = 'translate'
                       dispose()
            })
            button('Change settings', preferredSize:[120, 24],
                   actionPerformed:{
                       vars.dialogResult = 'updateSettings'
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

if (vars.dialogResult == 'translate') {
    /* Handle received data */
    l = vars.guiLanguage.getSelectedItem()
    LANGUAGE = SUPPORTED_LANGUAGES.find{it.value==l}.key
    if (LANGUAGE_CURRENT == LANGUAGE) {
        return // no translation is neeeded
    }
    
    translator = new NotationTranslator(DICTIONARY, SUPPORTED_LANGUAGES)
    /* Translate each node */
    c.findAllDepthFirst().findAll{it.hasStyle("White moves") || it.hasStyle("Black moves")}.each {aNode->
        text = aNode.getDisplayedText().replaceAll("\n","")
        if ((text != null) && (text != "")) {
            translator.setNotation(text, getNodePlyNumber(aNode)) 
            aNode.text = translator.translate(LANGUAGE_CURRENT, LANGUAGE) // pure notation without numbering
        }
        
        
    }    
    
    /* Update properties */
    chessTreeSettings.setProperty("chesstree_language", LANGUAGE)
}

if (vars.dialogResult == 'updateSettings') {
    l = vars.guiLanguage.getSelectedItem()
    LANGUAGE = SUPPORTED_LANGUAGES.find{it.value==l}.key

    /* Update properties */
    chessTreeSettings.setProperty("chesstree_language", LANGUAGE)
}





/*************/
/* Functions */
/*************/
def getNodePlyNumber(node) {
    return node.getNodeLevel(true) + ROOT_MOVENUMBER*2 - 1 
    // true : countHidden
}