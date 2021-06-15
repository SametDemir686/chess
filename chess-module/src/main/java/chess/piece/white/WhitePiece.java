package chess.piece.white;

import chess.board.Board;
import chess.piece.Piece;

public interface WhitePiece extends Piece {

    @Override
    default boolean isBlack() {
        return false;
    }

    @Override
    default boolean isWhite() {
        return true;
    }

    @Override
    default WhitePiece copy() {
        return copyToBoard(null);
    }

    WhitePiece copyToBoard(Board board);
}
