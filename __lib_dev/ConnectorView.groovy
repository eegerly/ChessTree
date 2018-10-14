package ChessTree
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
    
    public updateConnectors(useFreq) {
        ROOT.findAllDepthFirst().each {aNode->
            /* Update edge based on ["Freq"] */
            if (aNode.attributes.containsKey("Freq")) {
                updateEdge(aNode, useFreq);
            }

            /* Change edge to connector for "(un)wrapped" nodes (with negative (positive) horizontal shift) 
            with "*moves" style */
            updateNodeConnector(aNode)
        }
    }


    private updateEdge(aNode, useFreq) {
        width = 0
        if ((useFreq) && (aNode.parent != null)) { // not the root 
            width = (aNode["Freq"].toFloat()*MAXWIDTH/100.0).toInteger()
        }
        aNode.style.edge.setWidth(width)
        //println aNode.style.edge.getModel().getDash()
    }



    private updateNodeConnector(aNode) {
        def hasConnectorFromParent = aNode.connectorsIn.collect{it.getSource().id == aNode.parent.id}.inject(false){a,b->a||b}
        def hasHiddenEdgeFromParent = aNode.style.edge.type == org.freeplane.features.edge.EdgeStyle.EDGESTYLE_HIDDEN
        def hasMovesStyle = (aNode.hasStyle("White moves") || aNode.hasStyle("Black moves"))
        def hasNegativeHShift = (aNode.getHorizontalShift() < HSHIFT_LIMIT)
        
        if (hasNegativeHShift && hasMovesStyle && (!hasHiddenEdgeFromParent || !hasConnectorFromParent)) {
            aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {
                aNode.removeConnector(it)
            }
            
            def conn = aNode.parent.addConnectorTo(aNode)

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
            def vShift = (aNode.getVerticalShift() + aNode.style.getMinNodeWidth())>>1
            //aNode.children[0].findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.each{if (it.getVerticalShift()) println it.getVerticalShift()}
            def vShiftOffset = aNode.children[0].findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.collect{it.getVerticalShift()}.sum() // children at the topmost position
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

