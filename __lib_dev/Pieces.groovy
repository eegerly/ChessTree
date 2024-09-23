package ChessTree

import ChessTree.PositionInterpreter
import ChessTree.Notation


abstract class AbstractPiece {
    def allTargets = []
    def possibleMoves = []
    def possibleCaptures = []
    def attacksKing = false
    def position
    def color
    public AbstractPiece(color, position) {
        this.color = color
        this.position = position
        position[0] = [0,[position[0],7].min()].max()
        position[1] = [0,[position[1],7].min()].max()
        this.allTargets = getAllTargets()
    }
    public getPositionCoordinate() {return "abcdefgh"[position[0]]+"12345678"[position[1]]}
    public getAllTargetCoordinates() {return allTargets.collect{"abcdefgh"[it[0]]+"12345678"[it[1]]}}
    
    abstract getAllTargets()
    abstract calculatePossibleMoves(position) // todo: implement for each piece class
}

class Rook extends AbstractPiece {
    def getName() {return "Rook"}
    public Rook(color, position) {
        super(color, position)
    }
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        ((0..7)-square[0]).each{possibleMoves += [[it, square[1]]]}
        ((0..7)-square[1]).each{possibleMoves += [[square[0], it]]}
        
        return possibleMoves
    }
    def getAllTargets() {
        return getPossibleMovesFrom(this.position)
    }    
    def calculatePossibleMoves(position) {
        // can move to empty square
        // can capture any enemy piece 
        // can move only where check is ceased
        // blocked on line/row/totally if King would become checked
    }
}

class Bishop extends AbstractPiece {
    public Bishop(color, position) {
        super(color, position)
    }
    def getName() {return "Bishop"}
    def getPossibleMovesFrom(square) {
        def possibleMoves = []

        def x=square[0]
        def y=square[1]
        
        def x1 = (0..7).drop(x+1).take(7-[x,y].max())
        def y1 = (0..7).drop(y+1).take(7-[x,y].max())

        def x2 = (0..7).drop(x+1).take(7-[x,7-y].max())
        def y2 = (7..0).drop(8-y).take(7-[x,7-y].max())

        def x3 = (7..0).drop(8-x).take(7-[7-x,y].max())
        def y3 = (0..7).drop(y+1).take(7-[7-x,y].max())

        def x4 = (7..0).drop(8-x).take(7-[7-x,7-y].max())
        def y4 = (7..0).drop(8-y).take(7-[7-x,7-y].max())


        possibleMoves = (x1+x2+x3+x4).toList().withIndex().collect({it, idx -> [it,(y1+y2+y3+y4)[idx]]})   
        return possibleMoves
    } 
    
    
    def getAllTargets() {
        return getPossibleMovesFrom(this.position)
    }    
    def calculatePossibleMoves(position) {
        // can move to empty square
        // can capture any enemy piece 
        // can move only where check is ceased
        // blocked on diagonal if King would become checked
    }
}

class Knight extends AbstractPiece {
    public Knight(color, position) {
        super(color, position)
    }
    def getName() {return "Knight"}
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x=square[0]
        def y=square[1]
        
        possibleMoves = [
            [x-2, y-1],
            [x-2, y+1],
            [x-1, y+2],
            [x+1, y+2],
            [x+2, y+1],
            [x+2, y-1],
            [x+1, y-2],
            [x-1, y-2]
            ].findAll({it[0]>=0&&it[0]<8&&it[1]>=0&&it[1]<8})

        return possibleMoves
    }
    def getAllTargets() {
        return getPossibleMovesFrom(this.position)
    }    
    def calculatePossibleMoves(position) {
        // can move to empty square
        // can capture any enemy piece 
        // can move only where check is ceased
        // no possible move if King would become checked
    }
}

class Queen extends AbstractPiece {
    def getName() {return "Queen"}
    public Queen(color, position) {
        super(color, position)
    }
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x=square[0]
        def y=square[1]
        
        def x1 = (0..7).drop(x+1).take(7-[x,y].max())
        def y1 = (0..7).drop(y+1).take(7-[x,y].max())

        def x2 = (0..7).drop(x+1).take(7-[x,7-y].max())
        def y2 = (7..0).drop(8-y).take(7-[x,7-y].max())

        def x3 = (7..0).drop(8-x).take(7-[7-x,y].max())
        def y3 = (0..7).drop(y+1).take(7-[7-x,y].max())

        def x4 = (7..0).drop(8-x).take(7-[7-x,7-y].max())
        def y4 = (7..0).drop(8-y).take(7-[7-x,7-y].max())


        possibleMoves = (x1+x2+x3+x4).toList().withIndex().collect({it, idx -> [it,(y1+y2+y3+y4)[idx]]})   

        ((0..7)-square[0]).each{possibleMoves += [[it, square[1]]]}
        ((0..7)-square[1]).each{possibleMoves += [[square[0], it]]}
                        
        return possibleMoves
    }
    def getAllTargets() {
        return getPossibleMovesFrom(this.position)
    }    
    def calculatePossibleMoves(position) {
        // can move to empty square
        // can capture any enemy piece 
        // can move only where check is ceased
        // blocked on position/diagonal/line/row if King would become checked
    }
}

class King extends AbstractPiece {
    def getName() {return "King"}
    public King(color, position) {
        super(color, position)
    }
    
    def getPossibleMovesFrom(square) {
        def possibleMoves = []
        def x=square[0]
        def y=square[1]
        
        possibleMoves = [
            [x-1, y-1],
            [x-1, y],
            [x-1, y+1],
            [x, y-1],
            [x, y+1],
            [x+1, y-1],
            [x+1, y],
            [x+1, y+1]
            ].findAll({it[0]>=0&&it[0]<8&&it[1]>=0&&it[1]<8})

        return possibleMoves
    }
    def getAllTargets() {
        return getPossibleMovesFrom(this.position)
    }    
    def calculatePossibleMoves(position) {
        // can move to empty square
        // can move and capture enemy piece
        // can move only to not attacked squares 
        // cannot move to any of allTargets of enemy king
    }
}

class Pawn extends AbstractPiece {
    def getName() {return "Pawn"}
    public Pawn(color, position) {
        super(color, position)
        this.position[0] = [1,[this.position[0],6].min()].max()
        this.position[1] = [1,[this.position[1],6].min()].max()
    }
    
    def getPossibleMoves(square) {
        def possibleMoves = []
        def x=square[0]
        def y=square[1]
        def isPositiveDirection = (color=="w")
        possibleMoves = [
            [x-1, y+((isPositiveDirection) ? 1 : -1)],
            [x,   y+((isPositiveDirection) ? 1 : -1)],
            [x+1, y+((isPositiveDirection) ? 1 : -1)],
            ]
        
        /* add pawn double move */
        switch (y) {
            case 1: if (isPositiveDirection)  possibleMoves += [[x, 3]]; break;
            case 6: if (!isPositiveDirection)  possibleMoves += [[x, 4]]; break;
        }
        possibleMoves = possibleMoves.findAll({(it[0]>=0)&&(it[0]<8)&&(it[1]>=0)&&(it[1]<8)})
        
        return possibleMoves
    }
    def getPossibleMovesFrom(square) {
        getPossibleMoves(square)
    }
    
    def getAllTargets() {
        return getPossibleMovesFrom(this.position)
    }    
    def calculatePossibleMoves(position) {
        // can move to empty square 
        // can capture on enPassantTarget
        // can move only where check is ceased
        // cannot move if king would be checked
    }
}


