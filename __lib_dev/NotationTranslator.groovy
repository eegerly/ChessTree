package ChessTree
def class NotationTranslator {
    private dictionary
    private supportedLanguages
    private Notation notation
    def NotationTranslator(d, s) {
        this.dictionary = d
        this.supportedLanguages = s
        notation = new Notation("", 0)
    }
    def setNotation(text, plyNumber) { this.notation.set(text, plyNumber) }
    def getNotation() { return this.notation }
    
    def translate(fromLang, toLang){
        def color =  this.notation.getColor()
        def piece = this.notation.getPiece()
        def move = this.notation.getMove()
        def idx = dictionary[color].collect{it[fromLang]}.indexOf(piece)
        def notationTranslated = ""
        def pieceTranslated = ""
        if (idx >= 0) {
            pieceTranslated = dictionary[color][idx][toLang]
        }
        notationTranslated = move.replaceFirst(piece, pieceTranslated) 
        return notationTranslated       
   }
}


