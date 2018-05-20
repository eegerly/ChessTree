/*************/
/** Globals **/
/*************/

ROOT = this.node.map.root
mapfile=this.node.map.file
mapfilePath = mapfile.parent.replace("\\", "/")
mapfileName = mapfile.name.lastIndexOf('.').with {it != -1 ? mapfile.name[0..<it] : mapfile.name}
imgAbsPath = mapfilePath + "/img_" + mapfileName
imgRelPath = "./img_" + mapfileName

dir = new File(imgAbsPath)
if (!dir.exists()) {
    dir.mkdir()
}


/*************/
/**** Main ***/ 
/*************/

ROOT.findAllDepthFirst().each {
    aNode = it    
    /* Update edge based on ["Freq"] */
    if (aNode.attributes.containsKey("Freq")) {
        updateEdge(aNode);
    }

    /* Update pie chart for winning odds based on ["Odds"] */
    if (aNode.attributes.containsKey("Odds")) {
        if (!(aNode.children.findAll{it.style.name=="Explanation"}?.collect{it.getHtmlText()}[0]?.contains("<img"))) {
            /* ["Odds"] order: white, black, draw*/
            //updateOddsPieChart(aNode)
        }
    }
    
    /* Change edge to connector for "(un)wrapped" nodes (with negative (positive) horizontal shift) 
    with "*moves" style */
    updateNodeConnector(aNode)

    /* Update Notation from ["Language"] to ["LanguagePrev"] */    
    //updateNotation(aNode)

    
}

/*************/
/* Functions */
/*************/

/*
Google chart API:
https://developers.google.com/chart/image/docs/gallery/pie_charts#gcharts_chart_margins
*/
def updateOddsPieChart(aNode) {
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