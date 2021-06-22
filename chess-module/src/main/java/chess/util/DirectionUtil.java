package chess.util;

import chess.match.Direction;
import chess.notations.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;

import static chess.match.Direction.*;
import static java.lang.Math.abs;

public class DirectionUtil {
    private DirectionUtil() {
    }

    public static UnaryOperator<Position> parseToUnaryOperator(Direction direction) {
        switch (direction) {
            case UP:
                return Position::up;
            case DOWN:
                return Position::down;
            case LEFT:
                return Position::left;
            case RIGHT:
                return Position::right;
            case UP_LEFT:
                return Position::upLeft;
            case UP_RIGHT:
                return Position::upRight;
            case DOWN_LEFT:
                return Position::downLeft;
            case DOWN_RIGHT:
                return Position::downRight;
            case SELF:
                return UnaryOperator.identity();
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public static Direction findDirection(Position from, Position to) {
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

    public static int findMagnitudeSquare(Position from, Position to) {
        int vertice = from.getVerticalIndex() - to.getVerticalIndex();
        int horizon = from.getHorizontalIndex() - to.getHorizontalIndex();
        return vertice * vertice + horizon * horizon;
    }

    public static Set<Position> allPositionsInDirection(Position from, UnaryOperator<Position> director) {
        Position current = director.apply(from);
        Set<Position> result = new HashSet<>();
        while (current != null) {
            result.add(current);
            current = director.apply(current);
        }
        return result;
    }

    public static List<UnaryOperator<Position>> getAllDirections() {
        return Arrays.asList(
                Position::upLeft,
                Position::up,
                Position::upRight,
                Position::right,
                Position::downRight,
                Position::down,
                Position::downLeft,
                Position::left
        );
    }
}
