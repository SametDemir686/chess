package chess.piece.white;

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
}
