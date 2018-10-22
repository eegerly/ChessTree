package ChessTree
class OddsView {
    private nodeList
    private ROOT
    private mapfile
    private mapfilePath
    private mapfileName
    private imgAbsPath
    private imgRelPath

    def OddsView(map) {
        /* Setting up internal constants */
        ROOT = map.root
        mapfile=map.file
        mapfilePath = mapfile.parent.replace("\\", "/")
        mapfileName = mapfile.name.lastIndexOf('.').with {it != -1 ? mapfile.name[0..<it] : mapfile.name}
        imgAbsPath = mapfilePath + "/img_" + mapfileName
        imgRelPath = "./img_" + mapfileName        
        def dir = new File(imgAbsPath)
        if (!dir.exists()) {
            dir.mkdir()
        }    
    }
    def updateCharts(show) {
        ROOT.findAllDepthFirst().findAll{it.style.name!="Explanation"}.each {aNode->
            /* Update pie chart for winning odds based on ["Odds"] */
            if (aNode.attributes.containsKey("Odds")) {
                println aNode.id + " :: " + aNode.getDisplayedText() 
                
                def oddsChartNode = aNode.children.findAll{it.style.name=="Explanation"}?.findAll{it.attributes.containsKey("Odds")}
                if (oddsChartNode.size) {
                    oddsChartNode = oddsChartNode[0]
                    /* oddsChartNode has ["Odds"] in order to know whether it has been updated or not */
                    if (oddsChartNode["Odds"] != aNode["Odds"]) {
                        oddsChartNode["Odds"] = aNode["Odds"]
                        updateOddsPieChart(oddsChartNode)
                    }
                } else {
                    def odds = aNode["Odds"]
                    oddsChartNode = aNode.createChild("asdf")
                    oddsChartNode.style.setName("Explanation")
                    oddsChartNode.setFree(true)
                    oddsChartNode["Odds"] = odds
                    updateOddsPieChart(oddsChartNode)
                }
                oddsChartNode.setHideDetails(!show)
            }
        }    
    }
    /*
    Google chart API:
    https://developers.google.com/chart/image/docs/gallery/pie_charts#gcharts_chart_margins
    */
    def updateOddsPieChart(oddsChartNode) {
        /* ["Odds"] order: white, black, draw*/
        def odds=oddsChartNode["Odds"].split(",")
       
        def chartData=odds.reverse().join(",") /* chartData order: draw, black, white*/
       
        def chartLabels = "|" + odds.reverse()[1..2].join("|") // only white and black
        // chartLabels = odds.reverse().join("|")
        def chartRotation =  -Math.PI * ( 0.5  + odds[2].toFloat()/100.0)
       
        def chartURL = """https://chart.googleapis.com/chart""" +
                """?chs=120x50&cht=p""" +
                """&chd=t:${chartData}""" +
                """&chl=${chartLabels}""" +
                """&chco=555555|000000|DDDDDD""" +
                """&chp=${chartRotation}""" +
                //"""&chdlp=b|2,1&chdl=${chartLabels}""" +
                """&chma=0,0,0,0|0,0""" +
                """"""
        // println chartURL
       
        def oddsFileAbs = "${imgAbsPath}/odds_${oddsChartNode.id}.png"
        def oddsFileRel = "${imgRelPath}/odds_${oddsChartNode.id}.png"
        def file = new File(oddsFileAbs).newOutputStream() 
        file << new URL(chartURL).openStream()
        file.close()
       
        oddsChartNode.setDetails("""<html><body>
        <img src="${oddsFileRel}">
        </body></html>""")
    }        
}
