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
import ChessTree.PositionInterpreter

/*************/
/** Globals **/
/*************/
chessTreeSettings = new ChessTreeSettings(this.node.map)
/* CONSTANTS */ 
SUPPORTED_LANGUAGES = chessTreeSettings.SUPPORTED_LANGUAGES
DICTIONARY = chessTreeSettings.DICTIONARY

LANGUAGE_CURRENT = chessTreeSettings.get("chesstree_language").toString()

ROOT = this.node.map.root

/* FUNCTIONS */

/* Static functions for ClipBoard handling */ 
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

def getNodeFEN(aNode) {
    return aNode.attributes.containsKey("FEN") ? aNode["FEN"] : ""//: PositionInterpreter.FEN_STARTING
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
def translationNeeded = (PGN_LANGUAGE != LANGUAGE_CURRENT)
def nextNodeStack = []
def nextNodeStackAlt = []
def pgnNotation = new Notation(pgn, PGN_LANGUAGE)
def nodeNotation = new Notation(this.node.getDisplayedText(), LANGUAGE_CURRENT) // FEN is retrieved from PGN notation, not needed for nodeNotation

/* Determine starting node */
// Search for starting node with ancestors first order 
def currentNode = this.node
while (pgnNotation.getFEN() != getNodeFEN(currentNode)) {
    currentNode = currentNode.parent
    if (currentNode == null) {
        break;
    }
}


if (currentNode == null) {
    currentNode = this.node.createChild("Starting position") // no matching node found
    currentNode.style.setName("Starting position")
    currentNode["FEN"] = pgnNotation.position.FEN
}


/* Walk through PGN */

while (pgn.length() > 0) {
    if (pgnNotation.getMove() == "") {
        if (pgnNotation.getResult() != "") {
            currentNode.createChild(pgnNotation.getResult())
            currentNode.style.setName("Explanation")
        }
        break;
    }
    
    /* Parse ChessTree specific comment parts: Odds, Freq, Opening */
    comments = pgnNotation.getComment()
    odds = opening = freq = ""
    
    
    odds = (comments =~ /(?i)\s*odds\s*:\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*;/)
    if (odds.count>0) {
        comments = comments.replace(odds[0][0], "")
        odds = "${odds[0][1]},${odds[0][2]},${odds[0][3]}"
    } else {
        odds = ""
    }
    
    freq = (comments =~ /(?i)\s*freq\s*:\s*(\d+)\s*;/)
    if (freq.count>0) {
        comments = comments.replace(freq[0][0], "")
        freq = "${freq[0][1]}"
    } else {
        freq = ""
    }
    
    opening = (comments =~ /(?i)\s*opening\s*:\s*([^;]+)\s*;/)
    if (opening.count>0) {
        comments = comments.replace(opening[0][0], "")
        opening = "${opening[0][1]}"
    } else {
        opening = ""
    }
    
    nag = pgnNotation.getNAGtext()
    
    //println pgnNotation.getMoveNumber() + " _ " + pgnNotation.getMove() + " _ " + pgnNotation.getComment()
    //println "      " + odds + " _ " + freq + " _ " + opening
    println "*********************"
    println pgnNotation.getNumbering() + " " + pgnNotation.getMove()

    //println pgnNotation.getRemainingText()
    //println pgnNotation.branchingStarts() + " / " + pgnNotation.branchingEnds()

    /* Handle translated notation within chesstree */
    if (translationNeeded) {
        pgnNotation.translateTo(LANGUAGE_CURRENT)
        pgnNotation.setLanguage(PGN_LANGUAGE) // language is needed to set back as remainingText is not translated.
    }
    
    /* Process branching */
    def numOfUnusedBranches = pgnNotation.branchingEnds()-pgnNotation.branchingStarts()
    if (numOfUnusedBranches>0) { // Branch ends
        numOfUnusedBranches.times({
            currentNode=nextNodeStack.pop()
            nextNodeStackAlt.pop()
        })
    }
    
    if (pgnNotation.branchingStarts()) { // Branch starts : at least one move is assumed after one "(", no consecutive "("-s!
        if (pgnNotation.branchingEnds())
        {
            currentNode = nextNodeStackAlt[0]
        } else {
            nextNodeStackAlt.push(currentNode.parent)
            nextNodeStack.push(currentNode)
            currentNode = currentNode.parent
        }
    }
    
    /* Search for child node matching moveEng, FEN match is assumed */
    matchingChild = currentNode.children.find {
        nodeNotation.set(it.getDisplayedText()) // FEN is retrieved from PGN notation, not needed for nodeNotation
        if (pgnNotation.getMoveEng() == nodeNotation.getMoveEng()) {
            return true // found
        } else {
            return false // not found
        }
        
    }

    /* Process pgnNotation : node text */
    if (matchingChild == null) {
        // no mathing child found, create it
        currentNode = currentNode.createChild()
        currentNode.text = pgnNotation.getMove()
    } else {
        currentNode = matchingChild // matching child found, advance map processing
    }
    
    /* Process pgnNotation : node["FEN"] */
    /* Update FEN from pgn even if matching child was found and its FEN was correct. 
    FEN counters, enpassant, castling infos are guaranteed by starting position search at script startup. */
    currentNode["FEN"] = pgnNotation.positionAfterMove.FEN    

    /* Process pgnNotation : opening */
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
    /* Process pgnNotation : odds */
    if (odds != "") {
        currentNode["Odds"] = odds
        //TODO: wait for OddsView class, implement here update oddsNode, 
    }

    /* Process pgnNotation : frequency */
    if (freq != "") {
        currentNode["Freq"] = freq
        //TODO: wait for ConnectorView class, implement here update connector
    }
    /* Process pgnNotation : nag */
    if (nag != "") {
        currentNode["NAG"] = nag
        pgnNotation.getNAGs().each {
            def nagTxt = NotationTranslator.getNAG((it-"\$").toInteger(), "sym")
            if (currentNode.details) {
                currentNode.setDetailsText("${currentNode.details.to.plain}\n${nagTxt}")
            } else {
                currentNode.setDetailsText(nagTxt)
            }
        }
    }   
    /* Process pgnNotation : comments */
    if (comments != "") {
        commentsNode = currentNode.createChild("")
        commentsNode.style.setName("Explanation")
        commentsNode.setFree(true)
        commentsNode.setDetailsText(comments)
        commentsNode.setHorizontalShift(70)
        commentsNode.setVerticalShift(10)
    }
   
    /* Advance pgnNotation processing */
    pgn = pgnNotation.getRemainingText()
    pgnNotation.set(pgn)
}


return 0