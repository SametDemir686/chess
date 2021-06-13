package chess.piece;

import chess.match.A1Notation;
import chess.match.Direction;

public interface Piece {
    boolean canMoveTo(A1Notation newPosition);

    A1Notation getPosition();

    void setPosition(A1Notation position);

    boolean isBlack();

    boolean isWhite();

    void move();

    boolean canTreathen(Direction direction);

    boolean threatens(A1Notation position);

    void captured();

    boolean isActive();

    default boolean isCaptured() {
        return !isActive();
    }

    String getHTMLCode();
}
