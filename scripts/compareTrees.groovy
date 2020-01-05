if (c.getSelecteds().size()!=2) {
    ui.showMessage("Select exactly 2 nodes with style \"Starting position\".", 0)
    return 1
} else {
    if (!c.getSelecteds().every{it.hasStyle("Starting position")}) {
        ui.showMessage("Select exactly 2 nodes with style \"Starting position\".", 0)
        return 2
    }
}

original = c.getSelecteds()[0]
modified = c.getSelecteds()[1]
merged = original.parent.createChild("Merge")
merged.style.setName("Starting position")
merged["FEN"] = original["FEN"] // TODO compare FENs!
// TODO add position comparison, in case of a position match add connector
merged["Status"] = """= def icons = this.node.findAllDepthFirst().findAll{it.hasStyle("Diff.Added")||it.hasStyle("Diff.Priority")||it.hasStyle("Diff.Removed")}.collect{it.style.getStyleNode().icons.first}.unique()
this.node.icons.clear()
this.node.icons.addAll(icons)
return this.node.icons.getIcons().size()?"In progress":"Completed."
"""
merged["script.ChessTree"] = """
mergeFlags = this.node.findAllDepthFirst().findAll{it.hasStyle("Diff.Added")||it.hasStyle("Diff.Priority")||it.hasStyle("Diff.Removed")}.each{
    it.delete()
}
return 0
"""
merged.link.text="menuitem:_\$ExecuteScriptForSelectionAction\$0"

def walkThrough(orig, modd, merg) {
    def origChildrenTxt = orig.children.collect{it.text}
    def moddChildrenTxt = modd.children.collect{it.text}
    def removedChildrenTxt = origChildrenTxt-moddChildrenTxt
    def addedChildrenTxt = moddChildrenTxt-origChildrenTxt
    def commonChildrenTxt = origChildrenTxt.intersect(moddChildrenTxt)
    /* Check branch priority */
    // index distance of common items are the same
    if (commonChildrenTxt.collect{origChildrenTxt.indexOf(it)-moddChildrenTxt.indexOf(it)}.unique().size()>1) {
        def info=merg.createChild("")
        info.style.setName("Diff.Priority")
        info.setFree(true)
        info.setVerticalShift(-30)
    }
    /* DEBUG */
    //println "${orig}"
    //println "   Added: ${addedChildrenTxt}"
    //println "   Removed: ${removedChildrenTxt}"
    //println "   Common: ${commonChildrenTxt}"
    
    /* Check added */
    addedChildrenTxt.collect{txt->modd.children.findAll{txt==it.text}}.each{ 
        def info = merg.appendBranch(it)
        info = info.createChild("")
        info.style.setName("Diff.Added")
        info.setFree(true)
        info.setVerticalShift(-30)
    }
    /* Check removed */
    removedChildrenTxt.collect{txt->orig.children.findAll{txt==it.text}}.each{ 
        def info = merg.appendBranch(it)
        info = info.createChild("")
        info.style.setName("Diff.Removed")
        info.setFree(true)
        info.setVerticalShift(-30)
    }
    
    /* Unchanged: copy */
    commonChildrenTxt.collect{txt->
        [orig:orig.children.findAll{txt==it.text}[0],
         modd:modd.children.findAll{txt==it.text}[0]]
    }.each {
        merg = merg.appendChild(it.orig)
        walkThrough(it.orig, it.modd, merg)
    }
}

walkThrough(original, modified, merged)
return 0