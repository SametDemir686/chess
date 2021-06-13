package chess.piece;

import chess.match.A1Notation;
import chess.match.Direction;
import chess.match.MatchBoard;

import static chess.util.Util.findDirection;

public abstract class Queen extends AbstractPiece {

    protected Queen(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        return threatens(newPosition);
    }

    @Override
    public boolean threatens(A1Notation position) {
        if (!hasALookAt(position)) return false;
        return isDirectionNotBlocked(position);
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return direction.isValid();
    }

    private boolean hasALookAt(A1Notation to) {
        Direction direction = findDirection(position, to);
        return canTreathen(direction);
    }
}
