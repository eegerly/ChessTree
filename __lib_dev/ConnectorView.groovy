package ChessTree
import org.freeplane.features.link.ConnectorModel
//import org.freeplane.features.edge.EdgeStyle

class ConnectorView {
    private static final MAXWIDTH = 15
    private static final HSHIFT_LIMIT = -50
    /* Errors */
    private static errors = []
    private static final E_ACCESS_METHOD_GETCONNECTOR = 1
    private static ROOT
    
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
            def hasMovesStyle = (aNode.hasStyle("White moves") || aNode.hasStyle("Black moves"))
            if (hasMovesStyle) {
                updateNodeConnector(aNode)
            }
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



    public static updateNodeConnector(aNode) {
        def hasConnectorFromParent = aNode.connectorsIn.collect{it.getSource().id == aNode.parent.id}.inject(false){a,b->a||b}
        def hasHiddenEdgeFromParent = aNode.style.edge.getType().name == "hide_edge" //org.freeplane.features.edge.EdgeStyle.EDGESTYLE_HIDDEN
        def hasNegativeHShift = (aNode.getHorizontalShift() < HSHIFT_LIMIT)
        
        println "hasConnectorFromParent : " + hasConnectorFromParent
        println "hasHiddenEdgeFromParent : " + hasHiddenEdgeFromParent
        println "hasNegativeHShift : " + hasNegativeHShift
        
        /* Node's position : left to its parent AND 
           Connector or edge style is normal */
        if (hasNegativeHShift && (!hasHiddenEdgeFromParent || !hasConnectorFromParent)) {
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
                    connModel.setWidth(aNode.style.edge.width?:1)
                    connModel.setAlpha(255)

                }
            } catch (e) {
                //getConnector cannot be accessed...
            }
            def vShift = aNode.getVerticalShift()
            //def vShift = (aNode.getVerticalShift() + aNode.style.getMinNodeWidth())>>1
            //aNode.children[0]?.findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.each{if (it.getVerticalShift()) println it.getVerticalShift()}
            /* Sum of vertical shift */
            //def vShiftOffset = aNode.children[0]?.findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.collect{it.getVerticalShift()}.sum() // children at the topmost position
            //vShiftOffset = (vShiftOffset == null) ? 0:vShiftOffset
            
            //conn.setInclination([0, vShift-vShiftOffset], [-2*vShiftOffset, -vShift-vShiftOffset])
            conn.setInclination([vShift, vShift], [-vShift, -vShift])
            
            //aNode.style.edge.type = EdgeStyle.EDGESTYLE_HIDDEN
            aNode.style.edge.setType("hide_edge")
        }
        /* Node's position : right to its parent AND
           Connector or edge style has not yet been set back (connector based) */
        if (!hasNegativeHShift && (hasHiddenEdgeFromParent || hasConnectorFromParent)) {
            //aNode.style.name=""
            aNode.style.edge.type= "" //reset edge style to default
            aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {
                aNode.removeConnector(it)
            }        
        }
        if (hasNegativeHShift && hasConnectorFromParent) {
            def vShift = aNode.getVerticalShift()

            aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {
                    it.setInclination([vShift, vShift], [-vShift, -vShift])
                }
        }
    }
        
    
}

