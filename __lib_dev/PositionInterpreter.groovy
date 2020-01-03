package ChessTree

def class Board {
    def board = ["--------","--------","--------","--------","--------","--------","--------","--------"]
    public Board(){
        /* board is default empty board */
    }
    public Board(boardFEN){
        set(boardFEN)
    }
    /* column : x (0=a), row : y (0=1) */
    def putAt(x,y,c) {
        this.board[y] = this.board[y].take(x) + c + board[y].drop(x+1)
    }
    def getAt(x,y) { return this.board[y][x] }
    def removeAt(x,y) {
        this.putAt(x,y,"-")
    }
    def set(boardFEN) {
        def i,j
        def rows=boardFEN.split("/")
        for ( i=0;i<8;i++) {
            board[i]=rows[7-i]
            for (j=1;j<9;j++) { board[i]=board[i].replaceAll(j.toString(),"-"*j) }
        }
    }
    def getFEN() {
        def boardFEN = this.board.reverse().join("/")
        def f = ( boardFEN =~ /-+/ )
        f.each{
            boardFEN = boardFEN.replaceFirst(it, it.size().toString())
        }
        return boardFEN
    }
    def searchPiece(piece) {
        def positions = []
        this.board.eachWithIndex{ row, rowIdx ->
            "abcdefgh"[row.findIndexValues{it == piece}].each{positions+= (it+(rowIdx))}
        }
        return positions

    }    
    def printBoard() {
        this.board.reverse().each{println it}
    }
}

def class PositionInterpreter {
    public static final FEN_EMPTY = "8/8/8/8/8/8/8/8 w KQkq - 0 1" // empty board with no move
    public static final FEN_STARTING = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" // starting position
    def FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
    def castleTarget = "KQkq"
    def enPasssantTarget = "-"
    def halfMoveClock = 0
    def color = "w"
    def moveNumber = 1
    def plyNumber = 1
    def board = new Board()
    def PositionInterpreter(fen) {
        this.set(fen)
    }
    def PositionInterpreter() {
        // default constructor with starting position
    }
    
    def set(fen) {
        if (fen!="") FEN = fen
        def P_RANK = /[1-9rnbqkpRNBQKP]+/
        def P_BOARD = /($P_RANK\/$P_RANK\/$P_RANK\/$P_RANK\/$P_RANK\/$P_RANK\/$P_RANK\/$P_RANK)/
        
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

        /*P_BOARD: finder[0][1] */
        board.set(finder[0][1])
        /*P_NEXT=finder[0][2]*/
        def i=1
        color = finder[0][++i]
        castleTarget = finder[0][++i]
        enPasssantTarget = finder[0][++i]
        halfMoveClock = finder[0][++i].toInteger()
        moveNumber = finder[0][++i].toInteger()
        plyNumber = moveNumber*2 - ((color=="w")?1:0)
        /* Correct en passant target */
        /*
        if (enPasssantTarget.size()!=2) {enPasssantTarget = "-"}
        else if (!"abcdefgh".contains(enPasssantTarget[0]) || !"12345678".contains(enPasssantTarget[1])) {enPasssantTarget = "-"}
        else {
            switch (enPasssantTarget[1]) {
                case "3": // white's pawn can be captured
                    def colIdx = "abcdefgh".indexOf(enPasssantTarget[0])
                    if (colIdx < 0) {enPasssantTarget = "-"}
                    else {
                        if ((board[4][colIdx] != "P") || (board[5][colIdx] != "-") || (board[6][colIdx] != "-")) {enPasssantTarget = "-"}
                    }
                    break ;
                case "6": // black's pawn can be captured
                    def colIdx = "abcdefgh".indexOf(enPasssantTarget[0])
                    if (colIdx < 0) {enPasssantTarget = "-"}
                    else {
                        if ((board[3][colIdx] != "p") || (board[2][colIdx] != "-") ||(board[1][colIdx] != "-")) {enPasssantTarget = "-"}
                    }
                    break ;
                default : enPasssantTarget = "-"; break ;
            }
        }
        */
        /* Correct castling */
        /*
        if (board[0][4] != "k") {castleTarget-="k"; castleTarget-="q"}
        if (board[7][4] != "K") {castleTarget-="K"; castleTarget-="Q"}
        if (board[0][0] != "r") {castleTarget-="q"}
        if (board[0][7] != "r") {castleTarget-="k"}
        if (board[0][0] != "R") {castleTarget-="Q"}
        if (board[0][7] != "R") {castleTarget-="K"}
        */
    }
    
    def doMove(move) {
        /*********** Update board ***********/
        if (move!=null) {
            /* Special moves : castling */
            if (move=="0-0") {
                //doCastling("k")
            } else if (move == "0-0-0" ) {
                //doCastling("q")
            } else {
                if (move != "") {
                    def piece = ("abcdefgh".contains(move[0])) ? "p" : move[0]
                    piece = (this.color == "w") ? piece.toUpperCase() : piece.toLowerCase()
                    /* Special moves : en passant */
                    //update enPasssantTarget  
                    //update halfMoveClock
                }
            }
        }
        
        /************ Update FEN ***********/
        color = "wb"-color
        moveNumber += ((color=="w")?1:0)
        plyNumber = moveNumber*2 - ((color=="w")?1:0)
        halfMoveClock += 1
        
        FEN =  this.board.getFEN() + " " + color + " " + castleTarget + " " + enPasssantTarget + " " + halfMoveClock + " " + moveNumber
    }
    /*
    private doCastling(type) {
        def isNextWhite = (this.color == "w")
        def isKingSide = type.toLowerCase()=="k"
        def castleType =  isNextWhite ? type.toUpperCase() : type.toLowerCase()
        if (this.castleTarget.contains(castleType)) {
            def P_expPosition = (isKingSide ? /....k--r/ : /r---k.../)
            def canCastle = true
            canCastle &= (this.board[isNextWhite ? 7 : 0] ==~ /(?i)$P_expPosition/) 
            // TODO further conditions: isAttacked(king) && isAttacked(castlingKing) && isAttacked(castledKing)
            
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
    */
}