import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import ChessTree.Notation
import ChessTree.PositionInterpreter
import ChessTree.ChessTreeSettings

/*************/
/** Globals **/
/*************/
chessTreeSettings = new ChessTreeSettings(this.node.map)
LANGUAGE_CURRENT = chessTreeSettings.get("chesstree_language").toString()

static void setClipboardContents(final String contents){    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(contents), null)    }

PGN = ""

currentNotation = new Notation("", LANGUAGE_CURRENT)
currentNode=this.node
currentNode=currentNode.findAllDepthFirst().find{it.attributes.containsKey("FEN") && it.hasStyle("Starting position")}
def walkThrough(aNode, isNumberingNeeded) {
    def children = aNode.children.findAll{it.attributes.containsKey("FEN") && (it.hasStyle("White moves")||it.hasStyle("Black moves"))}
    def numberingNeeded = isNumberingNeeded
    if (children.size()>1) {
        currentNotation.setWithFEN(children[0].parent["FEN"].toString(), children[0].text)
        numberingNeeded |= (currentNotation.getColor() == "white")
        PGN += (numberingNeeded?(currentNotation.getNumbering() + " "):"") + children[0].text + " "
        (children-children[0]).each {
            currentNotation.setWithFEN(it.parent["FEN"].toString(), it.text)
            PGN += "(" + currentNotation.getNumbering() + " " + it.text + " "
            walkThrough(it, false)
        }
        walkThrough(children[0], true)
    } else if (children.size==1) {
        currentNotation.setWithFEN(children[0].parent["FEN"].toString(), children[0].text)
        numberingNeeded |= (currentNotation.getColor() == "white")
        PGN += (numberingNeeded?(currentNotation.getNumbering() + " "):"") + children[0].text + " "
        walkThrough(children[0], false)
    } else {
        PGN = PGN[0..-2]
        PGN += ") "
    }
}

walkThrough(currentNode, true)
PGN = PGN[0..-3] // last ")" is removed
println PGN
setClipboardContents(PGN)