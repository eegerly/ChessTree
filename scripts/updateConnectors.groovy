import org.freeplane.features.link.ConnectorModel
/*************/
/** Globals **/
/*************/

MAXWIDTH = 15
HSHIFT_LIMIT = -50
/* Errors */
errors = []
E_ACCESS_METHOD_GETCONNECTOR = 1
ROOT = this.node.map.root







/*************/
/**** Main ***/ 
/*************/

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

/* Error message handling */
errorMsg = ""
if (errors.contains(E_ACCESS_METHOD_GETCONNECTOR)) {
    errorMsg += "Width and transparency of connections cannot be set. Please set it manually.\n"
    "Or run script from script editor as connection.getConnector() method can be accessed only from script editor."
}
if (errors.size() > 0) {
    ui.showMessage(errorMsg, 2)
}

return 0;

/*************/
/* Functions */
/*************/

def updateEdge(aNode) {
    width = 0
    if (aNode.parent != null) { // not the root 
        width = (aNode["Freq"].toFloat()*MAXWIDTH/100.0).toInteger()
    }
    aNode.style.edge.setWidth(width)
    //println aNode.style.edge.getModel().getDash()
}



def updateNodeConnector(aNode) {
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
            errors.add(E_ACCESS_METHOD_GETCONNECTOR)
            errors = errors.unique()
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