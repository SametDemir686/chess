package chess.piece.black;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;
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

    public Stream<UnaryOperator<Position>> getAllPossibleDirections() {
        return Stream.of(Position::downLeft, Position::down, Position::downRight);
    }

    @Override
    public boolean isPromotion(Position moveTo) {
        return moveTo.isFirstRank();
    }

    @Override
    public BlackQueen promoteToQueen() {
        return promoteTo(new BlackQueen());
    }

    @Override
    public BlackRook promoteToRook() {
        return promoteTo(new BlackRook());
    }

    @Override
    public BlackBishop promoteToBishop() {
        return promoteTo(new BlackBishop());
    }

    @Override
    public BlackKnight promoteToKnight() {
        return promoteTo(new BlackKnight());
    }

    private <T extends BlackPiece> T promoteTo(T piece) {
        piece.setBoard(board);
        piece.setPosition(position);
        return piece;
    }
}
