package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import static chess.util.Util.findDirection;

public abstract class Rook extends AbstractPiece {
    protected Rook(Board board) {
        super(board);
    }

    protected Rook(Rook rook) {
        super(rook);
    }

    protected Rook(Rook rook, Board board) {
        super(rook, board);
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        return threatens(newPosition);
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return direction == Direction.LEFT
                || direction == Direction.RIGHT
                || direction == Direction.UP
                || direction == Direction.DOWN;
    }

    @Override
    public boolean threatens(A1Notation position) {
        return canTreathen(findDirection(this.position, position))
                && isDirectionNotBlocked(position);
    }
}
