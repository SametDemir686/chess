package chess.piece;

public interface Promotable extends Piece {
    default boolean isPromotable() {
        return true;
    }
}
