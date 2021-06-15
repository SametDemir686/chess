package chess.piece;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;

import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public abstract class Knight extends AbstractPiece {

    protected Knight() {
        super();
    }

    protected Knight(Knight knight) {
        super(knight);
    }

    protected Knight(Knight knight, Board board) {
        super(knight, board);
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        return threatens(newPosition);
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return false;
    }

    @Override
    public boolean threatens(A1Notation position) {
        int verDiff = abs(this.position.getVerticalIndex() - position.getVerticalIndex());
        int horDiff = abs(this.position.getHorizontalIndex() - position.getHorizontalIndex());
        return horDiff == 2 && verDiff == 1
                || horDiff == 1 && verDiff == 2;
    }

    @Override
    public Set<A1Notation> getAllPossibleSquares() {
        return getAllPossibleDirections()
                .map(s -> s.apply(position))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private Stream<UnaryOperator<A1Notation>> getAllPossibleDirections() {
        return Stream.of(
                A1Notation::upUpRight,
                A1Notation::upRightRight,
                A1Notation::upUpLeft,
                A1Notation::upLeftLeft,
                A1Notation::downDownRight,
                A1Notation::downRightRight,
                A1Notation::downDownLeft,
                A1Notation::downLeftLeft);
    }
}
