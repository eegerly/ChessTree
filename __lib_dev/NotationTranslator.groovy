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
    /*000*/ [sym:"", eng:"null annotation", fre:"", hun:""],
    /*001*/ [sym:"!", eng:"good move", fre:"", hun:""],
    /*002*/ [sym:"?", eng:"poor move or mistake", fre:"", hun:""],
    /*003*/ [sym:"!!", eng:"very good or brilliant move", fre:"", hun:""],
    /*004*/ [sym:"??", eng:"very poor move or blunder", fre:"", hun:""],
    /*005*/ [sym:"!?", eng:"speculative or interesting move", fre:"", hun:""],
    /*006*/ [sym:"?!", eng:"questionable or dubious move", fre:"", hun:""],
    /*007*/ [sym:"\u25a1", eng:"forced move (all others lose quickly) or only move", fre:"", hun:""],
    /*008*/ [sym:"", eng:"singular move (no reasonable alternatives)", fre:"", hun:""],
    /*009*/ [sym:"", eng:"worst move", fre:"", hun:""],
    /*010*/ [sym:"=", eng:"drawish position or even", fre:"", hun:""],
    /*011*/ [sym:"", eng:"equal chances, quiet position", fre:"", hun:""],
    /*012*/ [sym:"", eng:"equal chances, active position", fre:"", hun:""],
    /*013*/ [sym:"\u221e", eng:"unclear position", fre:"", hun:""],
    /*014*/ [sym:"\u2a72", eng:"White has a slight advantage", fre:"", hun:""],
    /*015*/ [sym:"\u2a71", eng:"Black has a slight advantage", fre:"", hun:""],
    /*016*/ [sym:"±", eng:"White has a moderate advantage", fre:"", hun:""],
    /*017*/ [sym:"\u2213", eng:"Black has a moderate advantage", fre:"", hun:""],
    /*018*/ [sym:"+-", eng:"White has a decisive advantage", fre:"", hun:""],
    /*019*/ [sym:"-+", eng:"Black has a decisive advantage", fre:"", hun:""],
    /*020*/ [sym:"", eng:"White has a crushing advantage (Black should resign)", fre:"", hun:""],
    /*021*/ [sym:"", eng:"Black has a crushing advantage (White should resign)", fre:"", hun:""],
    /*022*/ [sym:"\u2a00", eng:"White is in zugzwang", fre:"", hun:""],
    /*023*/ [sym:"\u2a00", eng:"Black is in zugzwang", fre:"", hun:""],
    /*024*/ [sym:"", eng:"White has a slight space advantage", fre:"", hun:""],
    /*025*/ [sym:"", eng:"Black has a slight space advantage", fre:"", hun:""],
    /*026*/ [sym:"", eng:"White has a moderate space advantage", fre:"", hun:""],
    /*027*/ [sym:"", eng:"Black has a moderate space advantage", fre:"", hun:""],
    /*028*/ [sym:"", eng:"White has a decisive space advantage", fre:"", hun:""],
    /*029*/ [sym:"", eng:"Black has a decisive space advantage", fre:"", hun:""],
    /*030*/ [sym:"", eng:"White has a slight time (development) advantage", fre:"", hun:""],
    /*031*/ [sym:"", eng:"Black has a slight time (development) advantage", fre:"", hun:""],
    /*032*/ [sym:"\u27f3", eng:"White has a moderate time (development) advantage", fre:"", hun:""],
    /*033*/ [sym:"\u27f3", eng:"Black has a moderate time (development) advantage", fre:"", hun:""],
    /*034*/ [sym:"", eng:"White has a decisive time (development) advantage", fre:"", hun:""],
    /*035*/ [sym:"", eng:"Black has a decisive time (development) advantage", fre:"", hun:""],
    /*036*/ [sym:"\u2192", eng:"White has the initiative", fre:"", hun:""],
    /*037*/ [sym:"\u2192", eng:"Black has the initiative", fre:"", hun:""],
    /*038*/ [sym:"", eng:"White has a lasting initiative", fre:"", hun:""],
    /*039*/ [sym:"", eng:"Black has a lasting initiative", fre:"", hun:""],
    /*040*/ [sym:"\u2191", eng:"White has the attack", fre:"", hun:""],
    /*041*/ [sym:"\u2191", eng:"Black has the attack", fre:"", hun:""],
    /*042*/ [sym:"", eng:"White has insufficient compensation for material deficit", fre:"", hun:""],
    /*043*/ [sym:"", eng:"Black has insufficient compensation for material deficit", fre:"", hun:""],
    /*044*/ [sym:"", eng:"White has sufficient compensation for material deficit", fre:"", hun:""],
    /*045*/ [sym:"", eng:"Black has sufficient compensation for material deficit", fre:"", hun:""],
    /*046*/ [sym:"", eng:"White has more than adequate compensation for material deficit", fre:"", hun:""],
    /*047*/ [sym:"", eng:"Black has more than adequate compensation for material deficit", fre:"", hun:""],
    /*048*/ [sym:"", eng:"White has a slight center control advantage", fre:"", hun:""],
    /*049*/ [sym:"", eng:"Black has a slight center control advantage", fre:"", hun:""],
    /*050*/ [sym:"", eng:"White has a moderate center control advantage", fre:"", hun:""],
    /*051*/ [sym:"", eng:"Black has a moderate center control advantage", fre:"", hun:""],
    /*052*/ [sym:"", eng:"White has a decisive center control advantage", fre:"", hun:""],
    /*053*/ [sym:"", eng:"Black has a decisive center control advantage", fre:"", hun:""],
    /*054*/ [sym:"", eng:"White has a slight kingside control advantage", fre:"", hun:""],
    /*055*/ [sym:"", eng:"Black has a slight kingside control advantage", fre:"", hun:""],
    /*056*/ [sym:"", eng:"White has a moderate kingside control advantage", fre:"", hun:""],
    /*057*/ [sym:"", eng:"Black has a moderate kingside control advantage", fre:"", hun:""],
    /*058*/ [sym:"", eng:"White has a decisive kingside control advantage", fre:"", hun:""],
    /*059*/ [sym:"", eng:"Black has a decisive kingside control advantage", fre:"", hun:""],
    /*060*/ [sym:"", eng:"White has a slight queenside control advantage", fre:"", hun:""],
    /*061*/ [sym:"", eng:"Black has a slight queenside control advantage", fre:"", hun:""],
    /*062*/ [sym:"", eng:"White has a moderate queenside control advantage", fre:"", hun:""],
    /*063*/ [sym:"", eng:"Black has a moderate queenside control advantage", fre:"", hun:""],
    /*064*/ [sym:"", eng:"White has a decisive queenside control advantage", fre:"", hun:""],
    /*065*/ [sym:"", eng:"Black has a decisive queenside control advantage", fre:"", hun:""],
    /*066*/ [sym:"", eng:"White has a vulnerable first rank", fre:"", hun:""],
    /*067*/ [sym:"", eng:"Black has a vulnerable first rank", fre:"", hun:""],
    /*068*/ [sym:"", eng:"White has a well protected first rank", fre:"", hun:""],
    /*069*/ [sym:"", eng:"Black has a well protected first rank", fre:"", hun:""],
    /*070*/ [sym:"", eng:"White has a poorly protected king", fre:"", hun:""],
    /*071*/ [sym:"", eng:"Black has a poorly protected king", fre:"", hun:""],
    /*072*/ [sym:"", eng:"White has a well protected king", fre:"", hun:""],
    /*073*/ [sym:"", eng:"Black has a well protected king", fre:"", hun:""],
    /*074*/ [sym:"", eng:"White has a poorly placed king", fre:"", hun:""],
    /*075*/ [sym:"", eng:"Black has a poorly placed king", fre:"", hun:""],
    /*076*/ [sym:"", eng:"White has a well placed king", fre:"", hun:""],
    /*077*/ [sym:"", eng:"Black has a well placed king", fre:"", hun:""],
    /*078*/ [sym:"", eng:"White has a very weak pawn structure", fre:"", hun:""],
    /*079*/ [sym:"", eng:"Black has a very weak pawn structure", fre:"", hun:""],
    /*080*/ [sym:"", eng:"White has a moderately weak pawn structure", fre:"", hun:""],
    /*081*/ [sym:"", eng:"Black has a moderately weak pawn structure", fre:"", hun:""],
    /*082*/ [sym:"", eng:"White has a moderately strong pawn structure", fre:"", hun:""],
    /*083*/ [sym:"", eng:"Black has a moderately strong pawn structure", fre:"", hun:""],
    /*084*/ [sym:"", eng:"White has a very strong pawn structure", fre:"", hun:""],
    /*085*/ [sym:"", eng:"Black has a very strong pawn structure", fre:"", hun:""],
    /*086*/ [sym:"", eng:"White has poor knight placement", fre:"", hun:""],
    /*087*/ [sym:"", eng:"Black has poor knight placement", fre:"", hun:""],
    /*088*/ [sym:"", eng:"White has good knight placement", fre:"", hun:""],
    /*089*/ [sym:"", eng:"Black has good knight placement", fre:"", hun:""],
    /*090*/ [sym:"", eng:"White has poor bishop placement", fre:"", hun:""],
    /*091*/ [sym:"", eng:"Black has poor bishop placement", fre:"", hun:""],
    /*092*/ [sym:"", eng:"White has good bishop placement", fre:"", hun:""],
    /*093*/ [sym:"", eng:"Black has good bishop placement", fre:"", hun:""],
    /*094*/ [sym:"", eng:"White has poor rook placement", fre:"", hun:""],
    /*095*/ [sym:"", eng:"Black has poor rook placement", fre:"", hun:""],
    /*096*/ [sym:"", eng:"White has good rook placement", fre:"", hun:""],
    /*097*/ [sym:"", eng:"Black has good rook placement", fre:"", hun:""],
    /*098*/ [sym:"", eng:"White has poor queen placement ", fre:"", hun:""],
    /*099*/ [sym:"", eng:"Black has poor queen placement", fre:"", hun:""],
    /*100*/ [sym:"", eng:"White has good queen placement", fre:"", hun:""],
    /*101*/ [sym:"", eng:"Black has good queen placement", fre:"", hun:""],
    /*102*/ [sym:"", eng:"White has poor piece coordination", fre:"", hun:""],
    /*103*/ [sym:"", eng:"Black has poor piece coordination", fre:"", hun:""],
    /*104*/ [sym:"", eng:"White has good piece coordination", fre:"", hun:""],
    /*105*/ [sym:"", eng:"Black has good piece coordination", fre:"", hun:""],
    /*106*/ [sym:"", eng:"White has played the opening very poorly", fre:"", hun:""],
    /*107*/ [sym:"", eng:"Black has played the opening very poorly", fre:"", hun:""],
    /*108*/ [sym:"", eng:"White has played the opening poorly", fre:"", hun:""],
    /*109*/ [sym:"", eng:"Black has played the opening poorly", fre:"", hun:""],
    /*110*/ [sym:"", eng:"White has played the opening well", fre:"", hun:""],
    /*111*/ [sym:"", eng:"Black has played the opening well", fre:"", hun:""],
    /*112*/ [sym:"", eng:"White has played the opening very well", fre:"", hun:""],
    /*113*/ [sym:"", eng:"Black has played the opening very well", fre:"", hun:""],
    /*114*/ [sym:"", eng:"White has played the middlegame very poorly", fre:"", hun:""],
    /*115*/ [sym:"", eng:"Black has played the middlegame very poorly", fre:"", hun:""],
    /*116*/ [sym:"", eng:"White has played the middlegame poorly", fre:"", hun:""],
    /*117*/ [sym:"", eng:"Black has played the middlegame poorly", fre:"", hun:""],
    /*118*/ [sym:"", eng:"White has played the middlegame well", fre:"", hun:""],
    /*119*/ [sym:"", eng:"Black has played the middlegame well", fre:"", hun:""],
    /*120*/ [sym:"", eng:"White has played the middlegame very well", fre:"", hun:""],
    /*121*/ [sym:"", eng:"Black has played the middlegame very well", fre:"", hun:""],
    /*122*/ [sym:"", eng:"White has played the ending very poorly", fre:"", hun:""],
    /*123*/ [sym:"", eng:"Black has played the ending very poorly", fre:"", hun:""],
    /*124*/ [sym:"", eng:"White has played the ending poorly", fre:"", hun:""],
    /*125*/ [sym:"", eng:"Black has played the ending poorly", fre:"", hun:""],
    /*126*/ [sym:"", eng:"White has played the ending well", fre:"", hun:""],
    /*127*/ [sym:"", eng:"Black has played the ending well", fre:"", hun:""],
    /*128*/ [sym:"", eng:"White has played the ending very well", fre:"", hun:""],
    /*129*/ [sym:"", eng:"Black has played the ending very well", fre:"", hun:""],
    /*130*/ [sym:"", eng:"White has slight counterplay", fre:"", hun:""],
    /*131*/ [sym:"", eng:"Black has slight counterplay", fre:"", hun:""],
    /*132*/ [sym:"\u21c6", eng:"White has moderate counterplay", fre:"", hun:""],
    /*133*/ [sym:"\u21c6", eng:"Black has moderate counterplay", fre:"", hun:""],
    /*134*/ [sym:"", eng:"White has decisive counterplay", fre:"", hun:""],
    /*135*/ [sym:"", eng:"Black has decisive counterplay", fre:"", hun:""],
    /*136*/ [sym:"", eng:"White has moderate time control pressure", fre:"", hun:""],
    /*137*/ [sym:"", eng:"Black has moderate time control pressure", fre:"", hun:""],
    /*138*/ [sym:"", eng:"White has severe time control pressure", fre:"", hun:""],
    /*139*/ [sym:"", eng:"Black has severe time control pressure ", fre:"", hun:""],
    /*140*/ [sym:"\u2206", eng:"With the idea...", fre:"", hun:""],
    /*141*/ [sym:"", eng:"Aimed against...", fre:"", hun:""],
    /*142*/ [sym:"\u2313", eng:"Better is...", fre:"", hun:""],
    /*143*/ [sym:"", eng:"Worse is...", fre:"", hun:""],
    /*144*/ [sym:"", eng:"Equivalent is...", fre:"", hun:""],
    /*145*/ [sym:"", eng:"Editorial comment", fre:"", hun:""],
    /*146*/ [sym:"N", eng:"Novelty", fre:"", hun:""],

    /*147*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*148*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*149*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*150*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*151*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*152*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*153*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*154*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*155*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*156*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*157*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*158*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*159*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*160*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*161*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*162*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*163*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*164*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*165*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*166*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*167*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*168*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*169*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*170*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*171*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*172*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*173*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*174*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*175*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*176*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*177*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*178*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*179*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*180*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*181*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*182*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*183*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*184*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*185*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*186*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*187*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*188*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*189*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*190*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*191*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*192*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*193*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*194*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*195*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*196*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*197*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*198*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*199*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*200*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*201*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*202*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*203*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*204*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*205*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*206*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*207*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*208*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*209*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*210*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*211*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*212*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*213*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*214*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*215*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*216*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*217*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*218*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*219*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],

    /*220*/ [sym:"", eng:"Diagram", fre:"", hun:""],
    /*221*/ [sym:"", eng:"Diagram", fre:"", hun:""], 		
    /*222*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*223*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*224*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*225*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*226*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*227*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*228*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*229*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*230*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*231*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*232*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*233*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*234*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*235*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*236*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],
    /*237*/ [sym:"", eng:"UNDEFINED", fre:"", hun:""],

    /*238*/ [sym:"", eng:"Space advantage", fre:"", hun:""],
    /*239*/ [sym:"\u21d4", eng:"File", fre:"", hun:""],
    /*240*/ [sym:"\u21D7", eng:"Diagonal", fre:"", hun:""],
    /*241*/ [sym:"", eng:"Centre", fre:"", hun:""],
    /*242*/ [sym:"\u27EB", eng:"King-side", fre:"", hun:""],
    /*243*/ [sym:"\u27EA", eng:"Queen-side", fre:"", hun:""],
    /*244*/ [sym:"\u2715", eng:"Weak point", fre:"", hun:""],
    /*245*/ [sym:"\u22A5", eng:"Ending", fre:"", hun:""],
    /*246*/ [sym:"", eng:"Bishop pair", fre:"", hun:""],
    /*247*/ [sym:"", eng:"Opposite Bishops", fre:"", hun:""],
    /*248*/ [sym:"", eng:"Same Bishops", fre:"", hun:""],
    /*249*/ [sym:"", eng:"Connected pawns", fre:"", hun:""],
    /*250*/ [sym:"", eng:"Isolated pawns", fre:"", hun:""],
    /*251*/ [sym:"", eng:"Doubled pawns", fre:"", hun:""],
    /*252*/ [sym:"", eng:"Passed pawn", fre:"", hun:""],
    /*253*/ [sym:"", eng:"Pawn majority", fre:"", hun:""],
    /*254*/ [sym:"", eng:"With", fre:"", hun:""],
    /*255*/ [sym:"", eng:"Without", fre:"", hun:""]
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


