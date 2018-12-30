package ChessTree
def class PositionInterpreter {
    public static final FEN_EMPTY = "8/8/8/8/8/8/8/8 w KQkq - 0 1" // empty board with no move
    public static final FEN_STARTING = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" // starting position
    def FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
    def nextColor = "w"
    def castleTarget = "KQkq"
    def enPasssantTarget = "-"
    def halfMoveClock = "0"
    def nextMoveNumber = "1"
    def color = "b"
    def moveNumber = "0"
    def plyNumber = "0"
    def board = ["rnbqkbnr", "pppppppp", "--------", "--------", "--------", "--------", "PPPPPPPP", "RNBQKBNR"]
    def PositionInterpreter(fen) {
        this.set(fen)
    }
    def PositionInterpreter() {
        // default constructor with starting position
    }
    
    def set(fen) {
        if (fen!="") FEN = fen

        def P_RANK = /[1-9rnbqkpRNBQKP]+/
        def P_BOARD = /($P_RANK)\/($P_RANK)\/($P_RANK)\/($P_RANK)\/($P_RANK)\/($P_RANK)\/($P_RANK)\/($P_RANK)/
        
        def P_NEXT = /([wb])/
        def P_CASTLE = /([kqKQ-]+)/
        // En passant target square
        def P_ENPASSANT = /([a-h36-]+)/
        // Half moves since last capture or pawn advance
        def P_HALFMOVECLOCK = /(\d+)/
        def P_MOVENUMBER = /(\d+)/
        def finder = (FEN =~ /(?msu)^$P_BOARD $P_NEXT $P_CASTLE $P_ENPASSANT $P_HALFMOVECLOCK $P_MOVENUMBER/)
        /* Handle illegal FEN */
        if (finder.size() == 0) {
            /* Try to get movenumber and color */
            finder = (FEN =~ /(?msu)^.* $P_NEXT .* $P_MOVENUMBER/)
            if (finder.size() == 0) {
                FEN = FEN_EMPTY
            }
            else {
                FEN = "8/8/8/8/8/8/8/8 ${finder[0][1]} KQkq - 0 ${finder[0][2]}"
            }
            finder = (FEN =~ /(?msu)^$P_BOARD $P_NEXT $P_CASTLE $P_ENPASSANT $P_HALFMOVECLOCK $P_MOVENUMBER/)
        }

        def i=0
        for ( i=0;i<8;i++) {
            board[i]=finder[0][i+1]
            def j=0
            for (j=1;j<9;j++) board[i]=board[i].replaceAll(j.toString(),"-"*j)
        }
        nextColor = finder[0][++i]
        castleTarget = finder[0][++i]
        enPasssantTarget = finder[0][++i]
        halfMoveClock = finder[0][++i].toInteger()
        nextMoveNumber = finder[0][++i].toInteger()
        color = "wb"-nextColor
        moveNumber = nextMoveNumber - ((nextColor=="w")?1:0)
        plyNumber = moveNumber*2 - ((color=="w")?1:0)        
    }
    
    def getBoardFEN() {
        def boardFEN = this.board.clone();
        for (def i=0; i<boardFEN.size(); i++) {
            def f = ( boardFEN[i] =~ /-+/ )
            f.each{
                boardFEN[i] = boardFEN[i].replaceFirst(it, it.size().toString())
            }
        }
        boardFEN = boardFEN.join("/")
        return boardFEN.join("/")
    }
    
    def doMove(move) {
        /*********** Update board ***********/
        if (move!=null) {
            /* Special moves : castling */
            if (move=="0-0") {
                doCastling("k")
            } else if (move == "0-0-0" ) {
                doCastling("q")
            } else {
                if (move != "") {
                    def piece = ("abcdefgh".contains(move[0])) ? "p" : move[0]
                    piece = (this.nextColor == "w") ? piece.toUpperCase() : piece.toLowerCase()
                    /* Special moves : en passant */
                    //update enPasssantTarget  
                    //update halfMoveClock
                }
            }
        }
        
        /************ Update FEN ***********/
        nextColor = "wb"-nextColor
        nextMoveNumber += ((nextColor=="w")? 1 : 0)
        color = "wb"-nextColor
        moveNumber = nextMoveNumber - ((nextColor=="w")?1:0)
        plyNumber = moveNumber*2 - ((color=="w")?1:0)
        
        
        FEN =  this.getBoardFEN() + " " + nextColor + " " + castleTarget + " " + enPasssantTarget + " " + nextMoveNumber
    }
    
    private doCastling(type) {
        def isNextWhite = (this.nextColor == "w")
        def isKingSide = type.toLowerCase()=="k"
        def castleType =  isNextWhite ? type.toUpperCase() : type.toLowerCase()
        if (this.castleTarget.contains(castleType)) {
            def P_expPosition = (isKingSide ? /....k--r/ : /r---k.../)
            def canCastle = true
            canCastle &= (this.board[isNextWhite ? 7 : 0] ==~ /(?i)$P_expPosition/) 
            /* TODO further conditions: isAttacked(king) && isAttacked(castlingKing) && isAttacked(castledKing)*/
            
            if (canCastle) {
                this.board[isNextWhite ? 7 : 0][isKingSide ? 7 : 0] = "-" // Rook's base
                this.board[isNextWhite ? 7 : 0][4] = "-" // King's base
                this.board[isNextWhite ? 7 : 0][isKingSide ? 6 : 2] = isNextWhite ? "K" : "k" // Castled rook
                this.board[isNextWhite ? 7 : 0][isKingSide ? 5 : 3] = isNextWhite ? "R" : "r" // Castled king
                
                this.castleTarget = this.castleTarget - (isNextWhite?"K":"k") - (isNextWhite?"Q":"q")
            }
        }
        halfMoveClock++
    }
    

}