package ChessTree

def class Notation {
    private notation = ""
    private move = ""
    private piece = ""
    private comment = ""
    private alternate = ""
    private remainingText = ""
    private tags = [:]
    private result = ""
    private PositionInterpreter position
    private PositionInterpreter positionAfterMove
    private nextPositionStack = []
    
    
    def Notation(String text) {
        position = new PositionInterpreter()
        positionAfterMove = new PositionInterpreter()
        
        this.set(text) // FEN is assumed to be the part of the text
    }
    def resetTags() {
        this.tags = [:]
    }
    def set(String text) {
        def P_NUMBERING = /\d+\.\s*\.*/ //1., 1.., 1. ., 1..., 1. .., 1.... etc.
        def P_MOVE = /[\u2654-\u265f\w\-=#\+]+/
        def P_COMMENT = /[^}]*/
        def P_TAG = /\[\s*(\w+)\s+"([^"]*)"\s*\]\s*/ /* " quotation mark for np++ highlighter  */
        def P_RESULT = /(1\/2-1\/2)|(1-0)|(0-1)|\*/
        def P_ALT_START = /\(+/
        def P_ALT_END = /\)+/
        // TODO one line comment with ;comment\n pattern
        // TODO multi level alternate moves
        // TODO Numeric Annotation Glyphs
        this.remainingText = text
        /* Parse tags */
        def hasFEN = false
        def tagFinder = (this.remainingText =~ /(?su)^$P_TAG/)
        while (tagFinder.count > 0) {
            this.tags[tagFinder[0][1]] = tagFinder[0][2]
            hasFEN |= (tagFinder[0][1]=="FEN")
            this.remainingText = this.remainingText.drop(tagFinder[0][0].length())
            tagFinder = (this.remainingText =~ /(?su)^$P_TAG/)
        }
        // if (!this.tags["FEN"]) {/* no action, default FEN will be used, FEN tag is not updated, only position */}
        
        /* Parse move text */
        def finder = (this.remainingText =~ /(?msu)^(($P_ALT_START){0,1}\s*($P_NUMBERING){0,1}\s*($P_MOVE)\s*(\{($P_COMMENT)\}){0,1}\s*($P_ALT_END){0,1}\s*)/)
        if (finder.count > 0) {
            this.notation = finder[0][1]?:""
            def numbering = finder[0][3]?:""
            this.move = finder[0][4]?:""
            this.comment = finder[0][6]?:""
            /* Extract piece */
            this.piece = ("abcdefgh0O".contains(this.move[0])) ? "" : this.move[0]
            this.alternate = (finder[0][2]?:"") +  (finder[0][7]?:"")
            
        } else {
            this.notation = text
            this.move = ""
            this.piece = ""
            this.comment = ""
        } // if finder.count
        
        this.remainingText = this.remainingText.drop(this.notation.length())
        
        /* Update position, nextPositionStack */
        if (hasFEN) {
            position.set(this.getTag("FEN")) // if no FEN, setter is called with ""
            nextPositionStack.clear()
        } else {
            if (nextPositionStack.isEmpty()) {// called from constructor
                position.set("") // setter is called with "" --> default FEN
            } else {
                if (!this.branchingStarts()) {
                    position = nextPositionStack.pop()
                } // else position is unchanged
            }
        }
        
        /* Update positionAfterMove */
        // copy position ; todo: remove workaround: boardFEN is a method local variable but groovy treats as attribute
        (positionAfterMove.properties.keySet() - ['class', 'metaClass', 'boardFEN']).each{positionAfterMove[it] = position[it]} 
        positionAfterMove.doMove(this.move)
        /* Update nextPositionStack */
        nextPositionStack.push(positionAfterMove)
        this.branchingEnds().times( { nextPositionStack.pop() } )
    } // set
    
    def branchingStarts() {
        return this.alternate.count("(")
    }
    def branchingEnds() {
        return this.alternate.count(")")
    }
    
    def updatePosition() {
        if (null != this.position) {
            this.position.doMove(this.move)
        }
    }
    
    def getNotation()   { return this.notation }
    def getMove()       { return this.move }
    def getPiece()      { return this.piece }
    def getNumbering()  { return (this.position.moveNumber) + ((this.color=="w") ? "." : "...") }
    def getComment()    { return this.comment }    
    def getAlternate()  { return this.alternate }
    def getColor()      { return (this.position.color == "w") ? "white" : "black"}
    def getMoveNumber() { return this.position.moveNumber}
    def getPlyNumber()  { return this.position.plyNumber }
    def getTag(tag)     { return this.tags.containsKey(tag) ? this.tags[tag] : "" }
    def getTagList()    { return this.tags.keySet()}
    def getRemainingText() { return this.remainingText }
    def getNextFEN()    {return this.position.FEN }
}