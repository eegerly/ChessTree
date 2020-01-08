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
    public static final NAGs= [
    [sym:"", eng:"null annotation", fre:"", hun:""],
    [sym:"!", eng:"good move", fre:"", hun:""],
    [sym:"?", eng:"poor move or mistake", fre:"", hun:""],
    [sym:"!!", eng:"very good or brilliant move", fre:"", hun:""],
    [sym:"??", eng:"very poor move or blunder", fre:"", hun:""],
    [sym:"!?", eng:"speculative or interesting move", fre:"", hun:""],
    [sym:"?!", eng:"questionable or dubious move", fre:"", hun:""],
    [sym:"\u25a1", eng:"forced move (all others lose quickly) or only move", fre:"", hun:""],
    [sym:"", eng:"singular move (no reasonable alternatives)", fre:"", hun:""],
    [sym:"", eng:"worst move", fre:"", hun:""],
    [sym:"=", eng:"drawish position or even", fre:"", hun:""],
    [sym:"", eng:"equal chances, quiet position", fre:"", hun:""],
    [sym:"", eng:"equal chances, active position", fre:"", hun:""],
    [sym:"\u221e", eng:"unclear position", fre:"", hun:""],
    [sym:"\u2a72", eng:"White has a slight advantage", fre:"", hun:""],
    [sym:"\u2a71", eng:"Black has a slight advantage", fre:"", hun:""],
    [sym:"±", eng:"White has a moderate advantage", fre:"", hun:""],
    [sym:"\u2213", eng:"Black has a moderate advantage", fre:"", hun:""],
    [sym:"+-", eng:"White has a decisive advantage", fre:"", hun:""],
    [sym:"-+", eng:"Black has a decisive advantage", fre:"", hun:""],
    [sym:"", eng:"White has a crushing advantage (Black should resign)", fre:"", hun:""],
    [sym:"", eng:"Black has a crushing advantage (White should resign)", fre:"", hun:""],
    [sym:"\u2a00", eng:"White is in zugzwang", fre:"", hun:""],
    [sym:"\u2a00", eng:"Black is in zugzwang", fre:"", hun:""],
    [sym:"", eng:"White has a slight space advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a slight space advantage", fre:"", hun:""],
    [sym:"", eng:"White has a moderate space advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a moderate space advantage", fre:"", hun:""],
    [sym:"", eng:"White has a decisive space advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a decisive space advantage", fre:"", hun:""],
    [sym:"", eng:"White has a slight time (development) advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a slight time (development) advantage", fre:"", hun:""],
    [sym:"\u27f3", eng:"White has a moderate time (development) advantage", fre:"", hun:""],
    [sym:"\u27f3", eng:"Black has a moderate time (development) advantage", fre:"", hun:""],
    [sym:"", eng:"White has a decisive time (development) advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a decisive time (development) advantage", fre:"", hun:""],
    [sym:"\u2192", eng:"White has the initiative", fre:"", hun:""],
    [sym:"\u2192", eng:"Black has the initiative", fre:"", hun:""],
    [sym:"", eng:"White has a lasting initiative", fre:"", hun:""],
    [sym:"", eng:"Black has a lasting initiative", fre:"", hun:""],
    [sym:"\u2191", eng:"White has the attack", fre:"", hun:""],
    [sym:"\u2191", eng:"Black has the attack", fre:"", hun:""],
    [sym:"", eng:"White has insufficient compensation for material deficit", fre:"", hun:""],
    [sym:"", eng:"Black has insufficient compensation for material deficit", fre:"", hun:""],
    [sym:"", eng:"White has sufficient compensation for material deficit", fre:"", hun:""],
    [sym:"", eng:"Black has sufficient compensation for material deficit", fre:"", hun:""],
    [sym:"", eng:"White has more than adequate compensation for material deficit", fre:"", hun:""],
    [sym:"", eng:"Black has more than adequate compensation for material deficit", fre:"", hun:""],
    [sym:"", eng:"White has a slight center control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a slight center control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a moderate center control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a moderate center control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a decisive center control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a decisive center control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a slight kingside control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a slight kingside control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a moderate kingside control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a moderate kingside control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a decisive kingside control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a decisive kingside control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a slight queenside control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a slight queenside control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a moderate queenside control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a moderate queenside control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a decisive queenside control advantage", fre:"", hun:""],
    [sym:"", eng:"Black has a decisive queenside control advantage", fre:"", hun:""],
    [sym:"", eng:"White has a vulnerable first rank", fre:"", hun:""],
    [sym:"", eng:"Black has a vulnerable first rank", fre:"", hun:""],
    [sym:"", eng:"White has a well protected first rank", fre:"", hun:""],
    [sym:"", eng:"Black has a well protected first rank", fre:"", hun:""],
    [sym:"", eng:"White has a poorly protected king", fre:"", hun:""],
    [sym:"", eng:"Black has a poorly protected king", fre:"", hun:""],
    [sym:"", eng:"White has a well protected king", fre:"", hun:""],
    [sym:"", eng:"Black has a well protected king", fre:"", hun:""],
    [sym:"", eng:"White has a poorly placed king", fre:"", hun:""],
    [sym:"", eng:"Black has a poorly placed king", fre:"", hun:""],
    [sym:"", eng:"White has a well placed king", fre:"", hun:""],
    [sym:"", eng:"Black has a well placed king", fre:"", hun:""],
    [sym:"", eng:"White has a very weak pawn structure", fre:"", hun:""],
    [sym:"", eng:"Black has a very weak pawn structure", fre:"", hun:""],
    [sym:"", eng:"White has a moderately weak pawn structure", fre:"", hun:""],
    [sym:"", eng:"Black has a moderately weak pawn structure", fre:"", hun:""],
    [sym:"", eng:"White has a moderately strong pawn structure", fre:"", hun:""],
    [sym:"", eng:"Black has a moderately strong pawn structure", fre:"", hun:""],
    [sym:"", eng:"White has a very strong pawn structure", fre:"", hun:""],
    [sym:"", eng:"Black has a very strong pawn structure", fre:"", hun:""],
    [sym:"", eng:"White has poor knight placement", fre:"", hun:""],
    [sym:"", eng:"Black has poor knight placement", fre:"", hun:""],
    [sym:"", eng:"White has good knight placement", fre:"", hun:""],
    [sym:"", eng:"Black has good knight placement", fre:"", hun:""],
    [sym:"", eng:"White has poor bishop placement", fre:"", hun:""],
    [sym:"", eng:"Black has poor bishop placement", fre:"", hun:""],
    [sym:"", eng:"White has good bishop placement", fre:"", hun:""],
    [sym:"", eng:"Black has good bishop placement", fre:"", hun:""],
    [sym:"", eng:"White has poor rook placement", fre:"", hun:""],
    [sym:"", eng:"Black has poor rook placement", fre:"", hun:""],
    [sym:"", eng:"White has good rook placement", fre:"", hun:""],
    [sym:"", eng:"Black has good rook placement", fre:"", hun:""],
    [sym:"", eng:"White has poor queen placement ", fre:"", hun:""],
    [sym:"", eng:"Black has poor queen placement", fre:"", hun:""],
    [sym:"", eng:"White has good queen placement", fre:"", hun:""],
    [sym:"", eng:"Black has good queen placement", fre:"", hun:""],
    [sym:"", eng:"White has poor piece coordination", fre:"", hun:""],
    [sym:"", eng:"Black has poor piece coordination", fre:"", hun:""],
    [sym:"", eng:"White has good piece coordination", fre:"", hun:""],
    [sym:"", eng:"Black has good piece coordination", fre:"", hun:""],
    [sym:"", eng:"White has played the opening very poorly", fre:"", hun:""],
    [sym:"", eng:"Black has played the opening very poorly", fre:"", hun:""],
    [sym:"", eng:"White has played the opening poorly", fre:"", hun:""],
    [sym:"", eng:"Black has played the opening poorly", fre:"", hun:""],
    [sym:"", eng:"White has played the opening well", fre:"", hun:""],
    [sym:"", eng:"Black has played the opening well", fre:"", hun:""],
    [sym:"", eng:"White has played the opening very well", fre:"", hun:""],
    [sym:"", eng:"Black has played the opening very well", fre:"", hun:""],
    [sym:"", eng:"White has played the middlegame very poorly", fre:"", hun:""],
    [sym:"", eng:"Black has played the middlegame very poorly", fre:"", hun:""],
    [sym:"", eng:"White has played the middlegame poorly", fre:"", hun:""],
    [sym:"", eng:"Black has played the middlegame poorly", fre:"", hun:""],
    [sym:"", eng:"White has played the middlegame well", fre:"", hun:""],
    [sym:"", eng:"Black has played the middlegame well", fre:"", hun:""],
    [sym:"", eng:"White has played the middlegame very well", fre:"", hun:""],
    [sym:"", eng:"Black has played the middlegame very well", fre:"", hun:""],
    [sym:"", eng:"White has played the ending very poorly", fre:"", hun:""],
    [sym:"", eng:"Black has played the ending very poorly", fre:"", hun:""],
    [sym:"", eng:"White has played the ending poorly", fre:"", hun:""],
    [sym:"", eng:"Black has played the ending poorly", fre:"", hun:""],
    [sym:"", eng:"White has played the ending well", fre:"", hun:""],
    [sym:"", eng:"Black has played the ending well", fre:"", hun:""],
    [sym:"", eng:"White has played the ending very well", fre:"", hun:""],
    [sym:"", eng:"Black has played the ending very well", fre:"", hun:""],
    [sym:"", eng:"White has slight counterplay", fre:"", hun:""],
    [sym:"", eng:"Black has slight counterplay", fre:"", hun:""],
    [sym:"\u21c6", eng:"White has moderate counterplay", fre:"", hun:""],
    [sym:"\u21c6", eng:"Black has moderate counterplay", fre:"", hun:""],
    [sym:"", eng:"White has decisive counterplay", fre:"", hun:""],
    [sym:"", eng:"Black has decisive counterplay", fre:"", hun:""],
    [sym:"", eng:"White has moderate time control pressure", fre:"", hun:""],
    [sym:"", eng:"Black has moderate time control pressure", fre:"", hun:""],
    [sym:"", eng:"White has severe time control pressure", fre:"", hun:""],
    [sym:"", eng:"Black has severe time control pressure ", fre:"", hun:""],
    ]
    
    
    static getNAG(nag, lang) {
        if (NAGs[nag][lang] == null ) { return NAGs[nag].eng}
        else if (NAGs[nag][lang].isEmpty()) { return NAGs[nag].eng}
        else { return NAGs[nag][lang]}
    }
    
    static translateNotation(toLang, notation){
        def pieceTranslated = translatePiece(toLang, notation)
        def moveTranslated = notation.getMove()
        moveTranslated = moveTranslated.replaceFirst(notation.getPiece(), pieceTranslated) 
        /* Translate promotion */
        def promotion = moveTranslated.indexOf("=")+1
        if (promotion != 0) {
            promotion = moveTranslated[promotion]
            promotion = NotationTranslator.DICTIONARY[notation.getColor()].find{it[notation.getLanguage()]==promotion}
            moveTranslated = moveTranslated.replaceFirst(promotion[notation.getLanguage()], promotion[toLang])
        }
        notation.setLanguage(toLang)
        notation.setMove(moveTranslated)
        notation.setPiece(pieceTranslated)
        
        return moveTranslated       
    }
    static getMoveEng(notation){
        def pieceTranslated = translatePiece("eng", notation)
        def moveTranslated = notation.getMove()
        moveTranslated = moveTranslated.replaceFirst(notation.getPiece(), pieceTranslated) 
        /* Translate promotion */
        def promotion = moveTranslated.indexOf("=")+1
        if (promotion != 0) {
            promotion = moveTranslated[promotion]
            promotion = NotationTranslator.DICTIONARY[notation.getColor()].find{it[notation.getLanguage()]==promotion}
            moveTranslated = moveTranslated.replaceFirst(promotion[notation.getLanguage()], promotion["eng"])
        }
        return moveTranslated
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


