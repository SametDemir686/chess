package chess.piece;

import chess.match.A1Notation;
import chess.match.Direction;
import chess.match.MatchBoard;

import static java.lang.Math.abs;

public abstract class King extends AbstractPiece {

    protected King(MatchBoard matchBoard) {
        super(matchBoard);
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
        return false;
    }

    private boolean hasALookAt(A1Notation otherPosition) {
        int horDiff = abs(otherPosition.getHorizontalIndex() - position.getHorizontalIndex());
        int verDiff = abs(otherPosition.getVerticalIndex() - position.getVerticalIndex());
        return horDiff <= 1 && verDiff <= 1;
    }

    @Override
    public boolean isPinned(A1Notation newPosition) {
        return false;
    }
}
