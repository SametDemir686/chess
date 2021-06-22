package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;

import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chess.util.DirectionUtil.findDirection;
import static chess.util.DirectionUtil.findMagnitudeSquare;

public abstract class Pawn extends AbstractPiece implements Promotable {
    protected Pawn() {
        super();
    }

    protected Pawn(Pawn aPawn) {
        super(aPawn);
    }

    protected Pawn(Pawn pawn, Board board) {
        super(pawn, board);
    }

    @Override
    public boolean threatens(Position position) {
        Direction direction = findDirection(this.position, position);
        int magnitudeSquare = findMagnitudeSquare(this.position, position);
        return canTreathen(direction) && magnitudeSquare == 2;
    }

    @Override
    public boolean canMoveTo(Position newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        Direction direction = findDirection(position, newPosition);
        int magnitudeSquare = findMagnitudeSquare(position, newPosition);
        if (canTreathen(direction) && magnitudeSquare == 2) {
            return isOccupiedByEnemyPiece(newPosition);
        } else if (canMove(direction)) {
            if (!hasMoved()) return magnitudeSquare == 1 || magnitudeSquare == 4;
            return magnitudeSquare == 1;
        }
        return false;
    }

    public abstract boolean canMove(Direction direction);

    @Override
    public Set<Position> getAllPossibleSquares() {
        return getAllPossibleDirections()
                .map(s -> s.apply(position))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    protected abstract Stream<UnaryOperator<Position>> getAllPossibleDirections();
}
