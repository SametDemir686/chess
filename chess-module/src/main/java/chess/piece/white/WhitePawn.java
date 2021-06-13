package chess.piece.white;

import chess.match.A1Notation;
import chess.match.Direction;
import chess.match.MatchBoard;
import chess.piece.Pawn;

import static chess.util.Util.findDirection;
import static chess.util.Util.findMagnitudeSquare;

public class WhitePawn extends Pawn implements WhitePiece {

    public WhitePawn(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "WP";
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        Direction direction = findDirection(position, newPosition);
        int magnitudeSquare = findMagnitudeSquare(position, newPosition);
        if (direction == Direction.UP_LEFT || direction == Direction.UP_RIGHT && magnitudeSquare == 2) {
            return board.isOccupiedByBlackPiece(newPosition);
        } else if (direction == Direction.UP) {
            if (!hasMoved()) return magnitudeSquare == 1 || magnitudeSquare == 4;
            else return magnitudeSquare == 1;
        }
        return false;
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return direction == Direction.UP_RIGHT
                || direction == Direction.UP_LEFT;
    }

    @Override
    public boolean threatens(A1Notation position) {
        return false;
    }

    @Override
    public String getHTMLCode() {
        return "&#9817;";
    }

    @Override
    public WhitePawn copy() {
        return new WhitePawn(null);
    }
}
