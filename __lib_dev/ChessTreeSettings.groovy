package ChessTree

def class ChessTreeSettings {
    /* Default setting is the first in each "SUPPORTED_*" attribute */
    public static final SUPPORTED_LANGUAGES = NotationTranslator.SUPPORTED_LANGUAGES
    public static final DICTIONARY = NotationTranslator.DICTIONARY
    public static final SUPPORTED_NUMBERING = ["none":"None", "white":"For white only", "both":"For both"]
    public static final SUPPORTED_NAG = ["hide":"Hide", "show":"Show"]
    public static final SUPPORTED_CONNECTOR = ["same":"Same", "freq":"Freq. based"]
    public static final SUPPORTED_ODDS = ["hide":"Hide", "show":"Show"]
    public static final SUPPORTED_BOARDSIZE = ["small":"Small", "medium":"Medium", "large":"Large"]
    private mapProperties
    private static final supportedProperties = [
        "chesstree_language" : SUPPORTED_LANGUAGES, 
        "chesstree_numbering" : SUPPORTED_NUMBERING, 
        "chesstree_NAG" : SUPPORTED_NAG, 
        "chesstree_board_size" : SUPPORTED_BOARDSIZE,
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
                    mapProperties[property] = supportedValues.keySet()[0]
                }
            } else { // no such property, set default
                mapProperties[property] = supportedValues.keySet()[0]
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
