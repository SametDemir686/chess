package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import static chess.util.DirectionUtil.findDirection;

public abstract class Bishop extends AbstractPiece {
    protected Bishop(Board board) {
        super(board);
    }

    protected Bishop(Bishop bishop) {
        super(bishop);
    }

    protected Bishop(Bishop bishop, Board board) {
        super(bishop, board);
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
        return direction == Direction.UP_LEFT
                || direction == Direction.UP_RIGHT
                || direction == Direction.DOWN_LEFT
                || direction == Direction.DOWN_RIGHT;
    }

    private boolean hasALookAt(A1Notation at) {
        Direction direction = findDirection(position, at);
        return canTreathen(direction);
    }

}
