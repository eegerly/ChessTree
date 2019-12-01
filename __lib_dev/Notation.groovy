package ChessTree

def class Notation {
    private notation = ""
    private move = ""
    private moveEng = "" //for PositionInterpreter.doMove(), 
    private piece = ""
    private comment = ""
    private alternate = ""
    private nag = ""
    private remainingText = ""
    private tags = [:]
    private result = ""
    private language = ""
    private PositionInterpreter position
    private PositionInterpreter positionAfterMove
    private nextPosStack = [] //Top of stack: position after recent branch ends and no starts. 
    private nextPosStackAlt = [] //Top of stack: position after recent branch ends and a new starts.    
    
    def Notation(String text, lang) {
        position = new PositionInterpreter()
        positionAfterMove = new PositionInterpreter()
        this.language = lang
        
        this.set(text) // FEN tag may be the part of the text
    }
    def Notation(String FEN, String text, lang) {
        position = new PositionInterpreter()
        positionAfterMove = new PositionInterpreter()
        this.language = lang
        
        this.setWithFEN(FEN, text) // FEN tag should not be the part of the text
    }
    
    def resetTags() {
        this.tags = [:]
    }
    
    def translateTo(lang) {
        NotationTranslator.translateNotation(lang, this)
    }
    
    def setMove(m)      { this.move = m }
    def setLanguage(l)  { this.language = l }
    def setPiece(p)     { this.piece = p }

    private parseMoveText(text) {
        def P_NUMBERING = /\d+\.\s*\.*/ //1., 1.., 1. ., 1..., 1. .., 1.... etc.
        def P_MOVE = /[\u2654-\u265f\w\-=#\+]+/
        def P_COMMENT = /[^}]*/
        def P_RESULT = /(1\/2-1\/2)|(1-0)|(0-1)|\*/ //currently not used 
        def P_ALT_END_START = /[\(\)\s]*/
        def P_NAG = /\$\d+/
        // TODO one line comment with ;comment\n pattern
        /* Parse move text */
        def finder = (text =~ /(?msu)^(($P_ALT_END_START){0,1}\s*($P_NUMBERING){0,1}\s*($P_MOVE)\s*(($P_NAG\s*)*)(\{($P_COMMENT)\}){0,1}\s*)/)
        if (finder.count > 0) {
            this.notation = finder[0][1]?:""
            def numbering = finder[0][3]?:""
            this.move = finder[0][4]?:""
            this.comment = finder[0][8]?:""
            /* Extract piece */
            this.piece = ("abcdefgh0O".contains(this.move[0])) ? "" : this.move[0]
            this.alternate = (finder[0][2]?:"")
            this.nag = (finder[0][5]?:"").split(/ +/)
            this.moveEng = NotationTranslator.getMoveEng(this)
        } else {
            this.notation = text // if no notation found, whole text will be dropped
            this.move = ""
            this.piece = ""
            this.comment = ""
            this.moveEng = ""
            this.alternate = ""
            this.nag = ""
        } // if finder.count
        
    }
    def setWithFEN(String FEN, String text) {
        set("[FEN \"${FEN?:''}\"] ${text}")
    }
    
    def set(String text) {
        def P_TAG = /\[\s*(\w+)\s+"([^"]*)"\s*\]\s*/ /* " quotation mark for np++ highlighter  */
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
        parseMoveText(this.remainingText)
        
        this.remainingText = this.remainingText.drop(this.notation.length())
        
        /* Update position, nextPosStack */
        if (hasFEN) { // Initialize position when FEN tag is received
            positionAfterMove.set(this.getTag("FEN")) // if no FEN, setter is called with ""
            // position is set by advancePosition() later
            nextPosStack.clear()
            nextPosStackAlt.clear()
            // TODO: destroy objects in stacks
        
        } 
        /* Process branching */
        def numOfUnusedBranches = branchingEnds()-branchingStarts()
        if (numOfUnusedBranches>0) { // Branch ends
            numOfUnusedBranches.times({
                position = null
                position=nextPosStack.pop()
                def x = nextPosStackAlt.pop()
                x = null
                })
        }
        
        if (branchingStarts()) { // Branch starts : at least one move is assumed after one "(", no consecutive "("-s!
            if (branchingEnds()) {
                copyObject(position, nextPosStackAlt[0])
            } else {
                nextPosStackAlt.push( new PositionInterpreter())
                copyObject(nextPosStackAlt[0], position)
                nextPosStack.push( new PositionInterpreter())
                copyObject(nextPosStack[0], positionAfterMove)
            }
        }
        if (branchingStarts() + branchingEnds() == 0) { // No branching
            advancePosition()
        }        
        
        /* Update positionAfterMove */
        updatePositionAfterMove()
    } // set
    
    private advancePosition() {        
        copyObject(position, positionAfterMove)
    }
    private copyObject(dst, src) {
        (dst.properties.keySet() - ['class', 'metaClass']).each{dst[it] = src[it]}     
    }
    
    def updatePositionAfterMove() {        
        copyObject(positionAfterMove, position)
        positionAfterMove.doMove(this.moveEng)
    }
    /* Branching counters for current move : can be used as triggers*/
    def branchingStarts()   { return this.alternate.count("(") }
    def branchingEnds()     { return this.alternate.count(")") }
    

    
    def getNotation()   { return this.notation }
    def getMove()       { return this.move }
    def getMoveEng()       { return this.moveEng }
    def getPiece()      { return this.piece }
    def getNumbering()  { return (this.position.moveNumber) + ((this.position.color=="w") ? "." : "...") }
    def getComment()    { return this.comment }    
    def getAlternate()  { return this.alternate }
    def getNAGs()       { return this.nag}    
    def getNAGtext()    { return this.nag.join(", ") }    
    def getColor()      { return (this.position.color == "w") ? "white" : "black"}
    def getMoveNumber() { return this.position.moveNumber}
    def getPlyNumber()  { return this.position.plyNumber }
    def getTag(tag)     { return this.tags.containsKey(tag) ? this.tags[tag] : "" }
    def getTagList()    { return this.tags.keySet()}
    def getRemainingText() { return this.remainingText }
    def getFEN()        { return this.position.FEN }
    def getNextFEN()    { return this.positionAfterMove.FEN }
    def getLanguage()   { return language }
}