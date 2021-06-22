package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;

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

    protected King(Position position) {
        super(position);
    }

    @Override
    public boolean canMoveTo(Position newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        if (isLongCastling(newPosition) && canLongCastle()) return true;
        if (isShortCastling(newPosition) && canShortCastle()) return true;
        if (!hasALookAt(newPosition)) return false;
        return !isTreathenedByEnemyPiece(newPosition);
    }

    public abstract boolean canShortCastle();

    public abstract boolean canLongCastle();

    public abstract boolean isShortCastling(Position newPosition);

    public abstract boolean isLongCastling(Position newPosition);

    @Override
    public boolean canTreathen(Direction direction) {
        return false;
    }

    @Override
    public boolean threatens(Position position) {
        return hasALookAt(position);
    }

    private boolean hasALookAt(Position otherPosition) {
        int horDiff = abs(otherPosition.getHorizontalIndex() - position.getHorizontalIndex());
        int verDiff = abs(otherPosition.getVerticalIndex() - position.getVerticalIndex());
        return horDiff <= 1 && verDiff <= 1;
    }

    @Override
    public Set<Position> getAllPossibleSquares() {
        return getAllDirections()
                .stream()
                .map(s -> s.apply(position))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public boolean isCastling(Position moveTo) {
        return isShortCastling(moveTo) && canShortCastle()
                || isLongCastling(moveTo) && canLongCastle();
    }
}
