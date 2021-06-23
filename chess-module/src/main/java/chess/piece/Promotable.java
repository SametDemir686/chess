package chess.piece;

import chess.notations.PromotionType;

import static chess.notations.PromotionType.*;

public interface Promotable extends Piece {
    Queen promoteToQueen();

    Rook promoteToRook();

    Bishop promoteToBishop();

    Knight promoteToKnight();

    default Piece promote(PromotionType promotionType) {
        if (promotionType == QUEEN) return promoteToQueen();
        if (promotionType == ROOK) return promoteToRook();
        if (promotionType == BISHOP) return promoteToBishop();
        if (promotionType == KNIGHT) return promoteToKnight();
        throw new IllegalStateException("Unexpected value: " + promotionType);
    }
}
