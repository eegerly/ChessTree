package ChessTree


def class ChessTreeSettings {
    /* Default setting is the first in each "SUPPORTED_*" attribute */
    public SUPPORTED_LANGUAGES = ["eng":"English", "sym":"Symbolic", "fre":"French", "hun":"Hungarian"]
    public DICTIONARY = ["white" : [
        ["sym":"\u2654", "eng":"K", "fre":"R", "hun":"K" ], // ♔
        ["sym":"\u2655", "eng":"Q", "fre":"D", "hun":"V" ], // ♕
        ["sym":"\u2656", "eng":"R", "fre":"T", "hun":"B" ], // ♖
        ["sym":"\u2657", "eng":"B", "fre":"F", "hun":"F" ], // ♗
        ["sym":"\u2658", "eng":"N", "fre":"C", "hun":"H" ], // ♘
        ["sym":"", "eng":"", "fre":"", "hun":"" ]           // ♙
        ],
        "black" : [
        ["sym":"\u265A", "eng":"K", "fre":"R", "hun":"K" ], // ♚
        ["sym":"\u265B", "eng":"Q", "fre":"D", "hun":"V" ], // ♛
        ["sym":"\u265C", "eng":"R", "fre":"T", "hun":"B" ], // ♜
        ["sym":"\u265D", "eng":"B", "fre":"F", "hun":"F" ], // ♝
        ["sym":"\u265E", "eng":"N", "fre":"C", "hun":"H" ], // ♞
        ["sym":"", "eng":"", "fre":"", "hun":"" ]           // ♟
        ]]
    public SUPPORTED_NUMBERING = ["none":"None", "white":"For white only", "both":"For both"]
    public SUPPORTED_NAG = ["hide":"Hide", "show":"Show"]
    public SUPPORTED_CONNECTOR = ["same":"Same", "freq":"Freq. based"]
    public SUPPORTED_ODDS = ["hide":"Hide", "show":"Show"]
    private mapProperties
    private supportedProperties = [
        "chesstree_language" : SUPPORTED_LANGUAGES, 
        "chesstree_numbering" : SUPPORTED_NUMBERING, 
        "chesstree_NAG" : SUPPORTED_NAG, 
        "chesstree_root_movenumber" : ["1" : "1", "\$PATTERN" : ~/[1-9]\d*/], // default is 1, pattern is the second
        "chesstree_connectors" : SUPPORTED_CONNECTOR, 
        "chesstree_odds" : SUPPORTED_ODDS
    ]

    def ChessTreeSettings(m) {
        mapProperties = m.getStorage()
        // check and correct map properties
        supportedProperties.each{property,supportedValues->
            if (mapProperties.keySet().contains(property)) {
                // if property does not match regex pattern of any supported value
                if (supportedValues.find{k,v -> mapProperties[property] ==~ k} == null) {
                    mapProperties[property] = supportedValues[0].getKey()
                }
            } else { // no such property, set default
                mapProperties[property] = supportedValues[0].getKey()
            }
        }
    }
    
    def get(property)      {return mapProperties[property]}
    def setByValue(property,value) {set(property,value,true)}
    def setByKey(property,key) {set(property,key,false)}
    private set(property,value,setByValue)      {
        if (supportedProperties.keySet().contains(property)) {
            def validProperty = supportedProperties[property].find{k,v-> value ==~ (setByValue?v:k)}
            if (validProperty != null) {
                if (validProperty.getKey() == "\$PATTERN") {
                    mapProperties[property] = value
                } else {
                    mapProperties[property] = validProperty.getKey()
                }
            } else {
                return -1 // value is not supported
            }
        } else {
            return -2 // property is not supported
        }
        return 0 // property is set
    }  
    def getSupportedProperties() {return supportedProperties.keySet()}
}