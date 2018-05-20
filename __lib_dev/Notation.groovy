package ChessTree

def class Notation {
    private notation = ""
    private move = ""
    private piece = ""
    private moveNumber = 0
    private comment = ""
    private plyNumber = 0
    private remainingText = ""
    private tags = [:]
    /* plyNumber starts from 1, 0 means unknown. set(text) will increase it. */
    def Notation(String text) {
        this(text, 0) // call the other constructor, plyNumber is unknown
    }
    def Notation(String text, int pn) {
        this.set(text, pn)
    }
    def resetTags() {
        this.tags = [:]
    }
    def set(String text, int pn) { 
        if (pn <= 0) {this.plyNumber = 0} // else plyNumber is supposed to be correct
        this.set(text)
        
        if (pn > 0) { // plyNumber is supposed to be correct
            this.plyNumber = pn
        }
    }
    def set(String text) {
        def P_NUMBERING = /\d+\.\s*\.*/ //1., 1.., 1. ., 1..., 1. .., 1.... etc.
        def P_MOVE = /[\u2654-\u265f\w\-=#\+]+/
        def P_COMMENT = /[^}]*/
        // TODO one line comment with ;comment\n pattern
        // TODO multi level alternate moves, (with comments) ... just store as this.alternate
        // TODO Numeric Annotation Glyphs
        this.remainingText = text
        def tagFinder = (this.remainingText =~ /(?msu)^\[\s*(\w+)\s+\"([^"]*)\"\s*\]\s*/)
        while (tagFinder.count > 0) {
            this.tags[tagFinder[0][1]] = tagFinder[0][2]
            this.remainingText = this.remainingText.drop(tagFinder[0][0].length())
            tagFinder = (this.remainingText =~ /(?msu)^\[\s*(\w+)\s+\"([^"]*)\"\s*\]\s*/)
        }
        
        def finder = (this.remainingText =~ /(?msu)^(($P_NUMBERING){0,1}\s*($P_MOVE)\s*(\{($P_COMMENT)\}){0,1}\s*)/)
        
        if (finder.count > 0) {
            this.notation = finder[0][1]?:""
            def numbering = finder[0][2]?:""
            this.move = finder[0][3]?:""
            this.comment = finder[0][5]?:""
            /* Extract piece */
            this.piece = ("abcdefgh0O".contains(this.move[0])) ? "" : this.move[0]

            /* Determine ply number */
            if (numbering){
                /* Determine ply number from numbering */
                /* Correct numbering if needed */
                numbering = numbering.replaceAll(/\s/,"")
                this.plyNumber = numbering.find(/\d+/).toInteger() * 2 - 1 // white is supposed
                if (numbering.count(".") > 1) this.plyNumber++; // black is supposed if dot number is more than 1
                
            } else {
                if (this.plyNumber > 0) {
                    /* Increase previous (unknown) plyNumber */
                    this.plyNumber++           
                    /* First action, as "1.e4 e5 1.d4"*/
                } else {
                    /* Determine numbering from next notation (supposed to be white) */
                    def nextNumbering = (this.remainingText.drop(this.notation.length()) =~ /(?msu)^($P_NUMBERING).*/)
                    nextNumbering = nextNumbering ? nextNumbering[0][0].find(/\d+/).toInteger() : 0
                    this.plyNumber = (nextNumbering - 1) * 2 - 1 // white is supposed
                    if (numbering.count(".") > 1) this.plyNumber++; // black is supposed if dot number is more than 1
                    /* if this.plyNumber <= 0, below final limiter will fix it to 1 */
                }                
            }            
            if (this.plyNumber <= 0) {
                this.plyNumber = 1
            }
            
        } else {
            this.notation = text
            this.move = ""
            this.piece = ""
            this.comment = ""
        } // if finder.count
        this.remainingText = this.remainingText.drop(this.notation.length())
    } // set
    
    def getNotation()   { return this.notation }
    def getMove()       { return this.move }
    def getPiece()      { return this.piece }
    def getNumbering()  { return (this.plyNumber >> 1) + ((this.plyNumber % 2) ? 1 : 0) + ((this.plyNumber % 2) ? "." : "...") }
    def getComment()    { return this.comment }
    def getColor()      { return (this.plyNumber > 0) ? (((this.plyNumber % 2) == 1) ? "white" : "black") : "" }
    def getMoveNumber() { return (this.plyNumber >> 1) + ((this.plyNumber % 2) ? 1 : 0)}
    def getPlyNumber()  { return this.plyNumber }
    def getTags()       { return this.tags }
    def getRemainingText() { return this.remainingText }
}
