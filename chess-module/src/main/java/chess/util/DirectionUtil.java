package chess.util;

import chess.match.A1Notation;
import chess.match.Direction;

import java.util.function.UnaryOperator;

import static chess.match.Direction.*;
import static java.lang.Math.abs;

public class DirectionUtil {
    private DirectionUtil() {
    }

    public static UnaryOperator<A1Notation> parseToUnaryOperator(Direction direction) {
        switch (direction) {
            case UP:
                return A1Notation::up;
            case DOWN:
                return A1Notation::down;
            case LEFT:
                return A1Notation::left;
            case RIGHT:
                return A1Notation::right;
            case UP_LEFT:
                return A1Notation::upLeft;
            case UP_RIGHT:
                return A1Notation::upRight;
            case DOWN_LEFT:
                return A1Notation::downLeft;
            case DOWN_RIGHT:
                return A1Notation::downRight;
            case SELF:
                return UnaryOperator.identity();
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public static Direction findDirection(A1Notation from, A1Notation to) {
        int horizon = from.getHorizontalIndex() - to.getHorizontalIndex();
        int vertice = from.getVerticalIndex() - to.getVerticalIndex();
        if (horizon == 0 && vertice == 0) return SELF;
        if (abs(vertice) == abs(horizon)) {
            if (vertice == horizon) {
                if (vertice < 0) return UP_RIGHT;
                else return DOWN_LEFT;
            } else {
                if (vertice < 0) return DOWN_RIGHT;
                else return UP_LEFT;
            }
        } else if (vertice == 0) {
            if (horizon < 0) return UP;
            else return DOWN;
        } else if (horizon == 0) {
            if (vertice < 0) return RIGHT;
            else return LEFT;
        }
        return NULL;
    }

    public static int findMagnitudeSquare(A1Notation from, A1Notation to) {
        int vertice = from.getVerticalIndex() - to.getVerticalIndex();
        int horizon = from.getHorizontalIndex() - to.getHorizontalIndex();
        return vertice * vertice + horizon * horizon;
    }

}
