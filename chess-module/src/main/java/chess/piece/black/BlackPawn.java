package chess.piece.black;

import chess.match.A1Notation;
import chess.match.Direction;
import chess.match.MatchBoard;
import chess.piece.Pawn;

import static chess.util.Util.findDirection;
import static chess.util.Util.findMagnitudeSquare;

public class BlackPawn extends Pawn implements BlackPiece {

    public BlackPawn(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "BP";
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        Direction direction = findDirection(position, newPosition);
        int magnitudeSquare = findMagnitudeSquare(position, newPosition);
        if (direction == Direction.DOWN_LEFT || direction == Direction.DOWN_RIGHT && magnitudeSquare == 2) {
            return board.isOccupiedByWhitePiece(newPosition);
        } else if (direction == Direction.DOWN) {
            if (!hasMoved()) return magnitudeSquare == 1 || magnitudeSquare == 4;
            else return magnitudeSquare == 1;
        }
        return false;
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return direction == Direction.DOWN_RIGHT
                || direction == Direction.DOWN_LEFT;
    }

    @Override
    public boolean threatens(A1Notation position) {
        Direction direction = findDirection(this.position, position);
        int magnitudeSquare = findMagnitudeSquare(this.position, position);
        return canTreathen(direction) && magnitudeSquare == 2;
    }

    @Override
    public String getHTMLCode() {
        return "&#9823;";
    }

    @Override
    public BlackPawn copy() {
        return new BlackPawn(null);
    }
}
