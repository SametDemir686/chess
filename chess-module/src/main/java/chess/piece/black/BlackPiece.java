package chess.piece.black;

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
}
