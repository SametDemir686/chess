package chess.piece.black;

import chess.board.Board;
import chess.piece.Piece;

public interface BlackPiece extends Piece {

    @Override
    default boolean isBlack() {
        return true;
    }

    @Override
    default boolean isWhite() {
        return false;
    }

    @Override
    default BlackPiece copy() {
        return copyToBoard(null);
    }

    BlackPiece copyToBoard(Board board);
}
