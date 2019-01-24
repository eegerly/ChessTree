package ChessTree
def class NotationTranslator {
    public static final SUPPORTED_LANGUAGES = ["eng":"English", "sym":"Symbolic", "fre":"French", "hun":"Hungarian"]
    public static final DICTIONARY = ["white" : [
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
    
    static translateNotation(toLang, notation){
        def pieceTranslated = translatePiece(toLang, notation)
        def moveTranslated = notation.getMove().replaceFirst(notation.getPiece(), pieceTranslated) // works also for pawn promotion e8=Q, e8Q
        notation.setLanguage(toLang)
        notation.setMove(moveTranslated)
        notation.setPiece(pieceTranslated)
        
        return moveTranslated       
    }
    static getMoveEng(notation){
        def pieceTranslated = translatePiece("eng", notation)
        def moveEng = notation.getMove().replaceFirst(notation.getPiece(), pieceTranslated) // works also for pawn promotion e8=Q, e8Q
        
        return moveEng       
    }

    static translatePiece(toLang, notation){
        def color =  notation.getColor()
        def piece = notation.getPiece()
        def move = notation.getMove()
        def fromLang = notation.getLanguage()
        def idx = DICTIONARY[color].collect{it[fromLang]}.indexOf(piece)
        def pieceTranslated = ""
        if (idx >= 0) {
            pieceTranslated = DICTIONARY[color][idx][toLang]
        }
        
        return pieceTranslated
    }
    
    
}


