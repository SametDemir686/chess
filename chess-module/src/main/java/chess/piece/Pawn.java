package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import static chess.util.Util.findDirection;
import static chess.util.Util.findMagnitudeSquare;

public abstract class Pawn extends AbstractPiece {
    protected Pawn(Board board) {
        super(board);
    }

    protected Pawn(Pawn aPawn) {
        super(aPawn);
    }

    protected Pawn(Pawn pawn, Board board) {
        super(pawn, board);
    }

    @Override
    public boolean threatens(A1Notation position) {
        Direction direction = findDirection(this.position, position);
        int magnitudeSquare = findMagnitudeSquare(this.position, position);
        return canTreathen(direction) && magnitudeSquare == 2;
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        Direction direction = findDirection(position, newPosition);
        int magnitudeSquare = findMagnitudeSquare(position, newPosition);
        if (canTreathen(direction) && magnitudeSquare == 2) {
            return isOccupiedByEnemyPiece(newPosition);
        } else if (canMove(direction)) {
            if (!hasMoved())
                return magnitudeSquare == 1 || magnitudeSquare == 4;
            else return magnitudeSquare == 1;
        }
        return false;
    }

    public abstract boolean canMove(Direction direction);
}
