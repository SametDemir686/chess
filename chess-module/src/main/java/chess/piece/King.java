package chess.piece;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static chess.util.DirectionUtil.getAllDirections;
import static java.lang.Math.abs;

public abstract class King extends AbstractPiece {

    protected King() {
        super();
    }

    protected King(King king) {
        super(king);
    }

    protected King(King king, Board board) {
        super(king, board);
    }

    protected King(A1Notation position, Board board) {
        super(position);
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        return super.canMoveTo(newPosition)
                && hasALookAt(newPosition)
                && !isTreathenedByEnemyPiece(newPosition);
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return false;
    }

    @Override
    public boolean threatens(A1Notation position) {
        return hasALookAt(position);
    }

    private boolean hasALookAt(A1Notation otherPosition) {
        int horDiff = abs(otherPosition.getHorizontalIndex() - position.getHorizontalIndex());
        int verDiff = abs(otherPosition.getVerticalIndex() - position.getVerticalIndex());
        return horDiff <= 1 && verDiff <= 1;
    }

    @Override
    public Set<A1Notation> getAllPossibleSquares() {
        return getAllDirections()
                .stream()
                .map(s -> s.apply(position))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

}
