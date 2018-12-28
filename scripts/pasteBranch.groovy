import org.freeplane.plugin.script.proxy.ScriptUtils
import groovy.swing.SwingBuilder
//import groovy.io.File
import groovy.io.FileType

import java.awt.FlowLayout as FL
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Action;
import java.awt.Font;

import javax.swing.BoxLayout as BXL
import javax.swing.JFrame
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane
import javax.swing.JFileChooser;

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection

import ChessTree.Notation
import ChessTree.NotationTranslator
import ChessTree.ChessTreeSettings

/*************/
/** Globals **/
/*************/
chessTreeSettings = new ChessTreeSettings(this.node.map)

/* CONSTANTS */ 
SUPPORTED_LANGUAGES = chessTreeSettings.SUPPORTED_LANGUAGES
DICTIONARY = chessTreeSettings.DICTIONARY

LANGUAGE_CURRENT = chessTreeSettings.get("chesstree_language")

ROOT = this.node.map.root

/* FUNCTIONS */

/* Static functions for ClipBoard handling */ 
//static void setClipboardContents(final String contents){    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(contents), null)    }
static String getClipboardContents(){    return Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor)    }

def showPGNFileChooser() {
    if(guiPGNFolderRB.selected) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose directory containing PGN files...");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getCurrentDirectory()
        } else {
            return ""
        }
    } else {
        return ""
    }

}

def switchPGNinput() {
    guiPGNClipboard.editable = guiPGNClipboardRB.selected    
    guiPGNClipboard.enabled = guiPGNClipboardRB.selected
    guiPGNFolder.editable = guiPGNFolderRB.selected
    guiPGNFolder.enabled = guiPGNFolderRB.selected    
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


/****************/
/**** M A I N ***/
/****************/

/* Build Dialog window */
def s = new SwingBuilder()
s.setVariable('myDialog-properties',[:])
def vars = s.variables
def disableItem(item) {vars.guiPGNClip.editable = false}

def dial = s.dialog(title:"Paste branch ...", id:'myDialog', modal:true, locationRelativeTo:ui.frame, owner:ui.frame, defaultCloseOperation:JFrame.DISPOSE_ON_CLOSE, pack:true, show:true) {
    panel(id:'pMain') {
        boxLayout(axis:BXL.Y_AXIS)
                
        guiPGNSource = buttonGroup();
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            guiPGNClipboardRB = radioButton(preferredSize: [150, 20], text:"PGN from ClipBoard", buttonGroup:guiPGNSource, selected:true, mouseClicked: {switchPGNinput()});
            scrollPane(horizontalScrollBarPolicy:JScrollPane.HORIZONTAL_SCROLLBAR_NEVER, verticalScrollBarPolicy:JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) {
                guiPGNClipboard = textArea( id:'guiPGNClip', columns: 60, rows: 6, font: new Font("Consolas", Font.PLAIN, 11), text: getClipboardContents(), wrapStyleWord:true, lineWrap:true)
            }
        }  	
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)            
            guiPGNFolderRB = radioButton(preferredSize: [150, 20], text:"PGN from folder", buttonGroup:guiPGNSource, mouseClicked: {switchPGNinput()});
            guiPGNFolder = textField(columns:60, font: new Font("Consolas", Font.PLAIN, 11), mouseClicked: { guiPGNFolder.text = showPGNFileChooser() }, editable: guiPGNFolderRB.selected)    
            
        }
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            label('Language', preferredSize: [60, 24])
			comboBox(id: 'guiLanguage', preferredSize: [100, 24], editable:true,
				items:SUPPORTED_LANGUAGES.collect{it.value}, selectedItem:SUPPORTED_LANGUAGES[LANGUAGE_CURRENT]) 
        }         
        panel(alignmentX:0f) {
            flowLayout(alignment:FL.LEFT)
            button('Paste', preferredSize:[110, 24],
                   actionPerformed:{
                       vars.dialogResult = 'paste'
                       dispose()
            })
            button('Cancel', preferredSize:[120, 24],
                   actionPerformed:{
                       vars.dialogResult = 'cancel'
                       dispose()
            })
        }
        panel(alignmentX:0f) {
        }
    }
}

/* Handle received data */
pgn = ""
if (vars.dialogResult == 'paste') {
	/* Update attributes */
    PGN_LANGUAGE = SUPPORTED_LANGUAGES.find{it.value == vars.guiLanguage.getSelectedItem()}.key
    switch (guiPGNSource.getSelection()) {
        case (guiPGNClipboardRB.model):
            pgn = guiPGNClipboard.text
            break;
        case (guiPGNFolderRB.model):
            dir = new File(guiPGNFolder.text)
            if (dir.path != "") {
                dir.eachDirRecurse() { dir ->  
                    dir.eachFileMatch(~/.*.pgn/) { file ->  
                        pgn += new File(file.getPath()).text
                    }  
                }  
            } // else no folder selected
            
            break;
        default: break;
    }
    

} else {
    return;
}


/* Initialization */
pgnNotation = new Notation(pgn)
nodeNotation = new Notation(this.node.getDisplayedText(), getNodePlyNumber(this.node))

/* Determine starting node */
// First check this.node
currentNode = null
if ((pgnNotation.getPlyNumber() != nodeNotation.getPlyNumber()) || 
    (pgnNotation.getMove() != nodeNotation.getMove())) {
    currentNode = c.findAll().find{ //breadth first order
        nodeNotation.set(it.getDisplayedText(), getNodePlyNumber(it))
        if (pgnNotation.getPlyNumber() < nodeNotation.getPlyNumber()) {
            return false // node's plyNumber is over notation's (breadth first!)
        }
        if ((pgnNotation.getPlyNumber() == nodeNotation.getPlyNumber()) &&
            (pgnNotation.getMove() == nodeNotation.getMove())) {
            return true // found
        } else {
            return false // not found
        }
    }
} else {
    currentNode = this.node
}

if (currentNode == null) {
    return -1 // no matching node found
}


// printNotation()
pgn = pgnNotation.getRemainingText()


translator = new NotationTranslator(DICTIONARY, SUPPORTED_LANGUAGES)

translationNeeded = (PGN_LANGUAGE != LANGUAGE_CURRENT)

/* Walk through PGN */

while (pgn.length() > 0) {
    pgnNotation.set(pgn)
    
    if (pgnNotation.getMove() == "") break;
    
    //parse comments for Odds, Freq, Opening
    comments = pgnNotation.getComment()
    odds = opening = freq = ""
    
    
    odds = (comments =~ /(?i)\s*odds\s*:\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*;/)
    if (odds.count>0) {
        //comments = comments.replace(odds[0][0], "")
        odds = "${odds[0][1]},${odds[0][2]},${odds[0][3]}"
    } else {
        odds = ""
    }
    
    freq = (comments =~ /(?i)\s*freq\s*:\s*(\d+)\s*;/)
    if (freq.count>0) {
        //comments = comments.replace(freq[0][0], "")
        freq = "${freq[0][1]}"
    } else {
        freq = ""
    }
    
    opening = (comments =~ /(?i)\s*opening\s*:\s*([^;]+)\s*;/)
    if (opening.count>0) {
        //comments = comments.replace(opening[0][0], "")
        opening = "${opening[0][1]}"
    } else {
        opening = ""
    }
    //println pgnNotation.getMoveNumber() + " _ " + pgnNotation.getMove() + " _ " + pgnNotation.getComment()
    //println "      " + odds + " _ " + freq + " _ " + opening

    // search for matching node for current pgn move 
    matchingChild = currentNode.children.find {
        nodeNotation.set(it.getDisplayedText(), getNodePlyNumber(it))
        if ((pgnNotation.getPlyNumber() == nodeNotation.getPlyNumber()) &&
            (pgnNotation.getMove() == nodeNotation.getMove())) {
            return true // found
        } else {
            return false // not found
        }
        
    }
    
    if (matchingChild == null) {
        // no mathing child found, create it
        currentNode = currentNode.createChild()
        def moveText = pgnNotation.getMove()
        if (translationNeeded) {
            translator.setNotation(moveText, getNodePlyNumber(currentNode))
            moveText = translator.translate(PGN_LANGUAGE, LANGUAGE_CURRENT)
        }
        currentNode.text = moveText
    } else {
        currentNode = matchingChild // matching child found, advance map processing
    }
    
    if (opening != "") {
        currentNode["Opening"] = opening
        if (currentNode.children.findAll{it.style.name=="Opening"}.size() > 0){
            currentNode.children.findAll{it.style.name=="Opening"}[-1].text = opening
        } else {
            opening = currentNode.createChild(opening)
            opening.style.setName("Opening")
            opening.setFree(true)
        }
    }
    if (odds != "") {
        currentNode["Odds"] = odds
        //TODO: wait for OddsView class, implement here update oddsNode, 
    }
    if (freq != "") {
        currentNode["Freq"] = freq
        //TODO: wait for ConnectorView class, implement here update connector
    }
   
    pgn = pgnNotation.getRemainingText()
}


return 0