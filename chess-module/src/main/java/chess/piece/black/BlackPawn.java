package chess.piece.black;

import chess.match.Board;
import chess.match.Direction;
import chess.piece.Pawn;

public class BlackPawn extends Pawn implements BlackPiece {

    public BlackPawn(Board board) {
        super(board);
    }

    public BlackPawn(BlackPawn aPawn) {
        super(aPawn);
    }

    public BlackPawn(BlackPawn blackPawn, Board board) {
        super(blackPawn, board);
    }

    @Override
    public String toString() {
        return "BP";
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

}
