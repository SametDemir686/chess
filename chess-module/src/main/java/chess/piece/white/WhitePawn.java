package chess.piece.white;

import chess.match.Board;
import chess.match.Direction;
import chess.piece.Pawn;

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

}
