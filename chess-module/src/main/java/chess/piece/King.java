package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import static java.lang.Math.abs;

public abstract class King extends AbstractPiece {

    protected King(Board board) {
        super(board);
    }

    protected King(King king) {
        super(king);
    }

    protected King(King king, Board board) {
        super(king, board);
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

    public boolean isPinned(A1Notation newPosition) {
        return false;
    }

}
