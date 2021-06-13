package chess.piece;

import chess.match.A1Notation;
import chess.match.Direction;
import chess.match.MatchBoard;

import static java.lang.Math.abs;

public abstract class Knight extends AbstractPiece {

    protected Knight(MatchBoard matchBoard) {
        super(matchBoard);
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
}
