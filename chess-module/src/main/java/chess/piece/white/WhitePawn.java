package chess.piece.white;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;
import chess.piece.Pawn;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class WhitePawn extends Pawn implements WhitePiece {

    public WhitePawn() {
        super();
    }

    public WhitePawn(WhitePawn whitePawn, Board board) {
        super(whitePawn, board);
    }

    public WhitePawn(WhitePawn pawn) {
        super(pawn);
    }

    @Override
    public String toString() {
        return "♙";
    }

    @Override
    public boolean canMove(Direction direction) {
        return direction == Direction.UP;
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

    @Override
    public Stream<UnaryOperator<A1Notation>> getAllPossibleDirections() {
        return Stream.of(A1Notation::upLeft, A1Notation::up, A1Notation::upRight);
    }
}
