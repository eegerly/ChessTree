package ChessTree

import ChessTree.PositionInterpreter
import ChessTree.Notation


abstract class AbstractPiece {
    def possibleTargets = []
    def position
    def color
    public AbstractPiece(color, position) {
        this.color = color
        this.position = position
        this.possibleTargets = getPossibleMovesFromSource()
        
        
    }
    abstract getPossibleMovesFromSource()
    //abstract restrictPossibleTargets() // todo: implement for each piece class
}

class Rook extends AbstractPiece {
    def getName() {println "Rook"}
    public Rook(color, position) {
        super(color, position)
    }
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        ("abcdefgh"-square[0]).each{possibleMoves += (it + square[1])}
        ("12345678"-square[1]).each{possibleMoves += (square[0] + it)}
        return possibleMoves
    }
    def getPossibleMovesFromSource() {
        return getPossibleMovesFrom(this.position)
    }    
}

class Bishop extends AbstractPiece {
    public Bishop(color, position) {
        super(color, position)
    }
    def getName() {println "Bishop"}
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x="abcdefgh".indexOf(square[0])+1
        def y="12345678".indexOf(square[1])+1
        
        def x1 = "abcdefgh".drop(x).take(8-[x,y].max())
        def y1 = "12345678".drop(y).take(8-[x,y].max())
        
        def x2 = "abcdefgh".drop(x).take(8-[x,9-y].max())
        def y2 = "87654321".drop(9-y).take(8-[x,9-y].max())
        
        def x3 = "hgfedcba".drop(9-x).take(8-[9-x,y].max())
        def y3 = "12345678".drop(y).take(8-[9-x,y].max())
        
        def x4 = "hgfedcba".drop(9-x).take(8-[9-x,9-y].max())
        def y4 = "87654321".drop(9-y).take(8-[9-x,9-y].max())
        
        
        possibleMoves = (x1+x2+x3+x4).toList().withIndex().collect({it, idx -> it+(y1+y2+y3+y4)[idx]})   
        return possibleMoves
    } 
    
    
    def getPossibleMovesFromSource() {
        return getPossibleMovesFrom(this.position)
    }    
}

class Knight extends AbstractPiece {
    public Knight(color, position) {
        super(color, position)
    }
    def getName() {println "Knight"}
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x="abcdefgh".indexOf(square[0])
        def y="12345678".indexOf(square[1])        
        
        possibleMoves = [
            [x-2, y-1],
            [x-2, y+1],
            [x-1, y+2],
            [x+1, y+2],
            [x+2, y+1],
            [x+2, y-1],
            [x+1, y-2],
            [x-1, y-2]
            ].findAll({it[0]>0&&it[0]<8&&it[1]>0&&it[1]<8}).collect({"abcdefgh"[it[0]]+"12345678"[it[1]]})

        return possibleMoves
    }
    def getPossibleMovesFromSource() {
        return getPossibleMovesFrom(this.position)
    }    
}

class Queen extends AbstractPiece {
    def getName() {println "Queen"}
    public Queen(color, position) {
        super(color, position)
    }
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x="abcdefgh".indexOf(square[0])+1
        def y="12345678".indexOf(square[1])+1
        
        def x1 = "abcdefgh".drop(x).take(8-[x,y].max())
        def y1 = "12345678".drop(y).take(8-[x,y].max())
        
        def x2 = "abcdefgh".drop(x).take(8-[x,9-y].max())
        def y2 = "87654321".drop(9-y).take(8-[x,9-y].max())
        
        def x3 = "hgfedcba".drop(9-x).take(8-[9-x,y].max())
        def y3 = "12345678".drop(y).take(8-[9-x,y].max())
        
        def x4 = "hgfedcba".drop(9-x).take(8-[9-x,9-y].max())
        def y4 = "87654321".drop(9-y).take(8-[9-x,9-y].max())
        
        
        possibleMoves = (x1+x2+x3+x4).toList().withIndex().collect({it, idx -> it+(y1+y2+y3+y4)[idx]})   
        ("abcdefgh"-square[0]).each{possibleMoves += (it + square[1])}
        ("12345678"-square[1]).each{possibleMoves += (square[0] + it)}
                        
        return possibleMoves
    }
    def getPossibleMovesFromSource() {
        return getPossibleMovesFrom(this.position)
    }    
}

class King extends AbstractPiece {
    def getName() {println "King"}
    public King(color, position) {
        super(color, position)
    }
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x="abcdefgh".indexOf(square[0])
        def y="12345678".indexOf(square[1])        
        
        possibleMoves = [
            [x-1, y-1],
            [x-1, y],
            [x-1, y+1],
            [x, y-1],
            [x, y+1],
            [x+1, y-1],
            [x+1, y],
            [x+1, y+1]
            ].findAll({it[0]>0&&it[0]<8&&it[1]>0&&it[1]<8}).collect({"abcdefgh"[it[0]]+"12345678"[it[1]]})

        return possibleMoves
    }
    def getPossibleMovesFromSource() {
        return getPossibleMovesFrom(this.position)
    }    
}

class Pawn extends AbstractPiece {
    def getName() {println "Pawn"}
    public Pawn(color, position) {
        super(color, position)
    }
    
    def getPossibleMoves(square, isForward) {
        def possibleMoves = []
        def x="abcdefgh".indexOf(square[0])
        def y="12345678".indexOf(square[1])        
        def isPositiveDirection = (color=="w" && isForward) || (color=="b" && (!isForward))
        possibleMoves = [
            [x-1, y+((isPositiveDirection) ? 1 : -1)],
            [x-1, y+((isPositiveDirection) ? 1 : -1)],
            [x-1, y+((isPositiveDirection) ? 1 : -1)],
            ].findAll({it[0]>0&&it[0]<8&&it[1]>0&&it[1]<8}).collect({"abcdefgh"[it[0]]+"12345678"[it[1]]})
        
        // add pawn double move, (enPassantTargetSquare)
        switch (y) {
            case 1: if (isForward  && color=="w")  possibleMoves += [x, 3]; break;
            case 3: if (!isForward  && color=="w") possibleMoves += [x, 1]; break;
            case 4: if (!isForward  && color=="b") possibleMoves += [x, 6]; break;
            case 6: if (isForward  && color=="b")  possibleMoves += [x, 4]; break;
        }
        
        
        possibleMoves = possibleMoves.findAll({it[0]>0&&it[0]<8&&it[1]>0&&it[1]<8}).collect({"abcdefgh"[it[0]]+"12345678"[it[1]]})
        
        
        return possibleMoves
    }
    def getPossibleMovesFrom(square) {
        getPossibleMoves(square, true)
    }
    def getPossibleMovesTo(square) {
        getPossibleMoves(square, false)
    }
    
    
    def getPossibleMovesFromSource() {
        return getPossibleMovesFrom(this.position)
    }    
}


