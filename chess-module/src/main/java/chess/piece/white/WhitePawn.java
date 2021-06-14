package chess.piece.white;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;
import chess.piece.Pawn;

import static chess.util.Util.findDirection;
import static chess.util.Util.findMagnitudeSquare;

public class WhitePawn extends Pawn implements WhitePiece {

    public WhitePawn(Board board) {
        super(board);
    }

    public WhitePawn(WhitePawn whitePawn, Board board) {
        super(whitePawn, board);
    }

    public WhitePawn(WhitePawn pawn) {
        super(pawn);
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
    public String getHTMLCode() {
        return "&#9817;";
    }

    @Override
    public WhitePawn copyToBoard(Board board) {
        return new WhitePawn(this, board);
    }

}
