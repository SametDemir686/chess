package chess.piece.black;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;
import chess.piece.Pawn;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class BlackPawn extends Pawn implements BlackPiece {

    public BlackPawn() {
        super();
    }

    public BlackPawn(BlackPawn aPawn) {
        super(aPawn);
    }

    public BlackPawn(BlackPawn blackPawn, Board board) {
        super(blackPawn, board);
    }

    @Override
    public String toString() {
        return "♟";
    }

    @Override
    public boolean canMove(Direction direction) {
        return direction == Direction.DOWN;
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return direction == Direction.DOWN_RIGHT
                || direction == Direction.DOWN_LEFT;
    }

    @Override
    public String getHTMLCode() {
        return "&#9823;";
    }

    @Override
    public BlackPawn copyToBoard(Board board) {
        return new BlackPawn(this, board);
    }

    public Stream<UnaryOperator<A1Notation>> getAllPossibleDirections() {
        return Stream.of(A1Notation::downLeft, A1Notation::down, A1Notation::downRight);
    }
}
