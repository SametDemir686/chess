package chess.piece;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;
import chess.util.DirectionUtil;
import chess.util.Sets;

import java.util.Set;

import static chess.util.DirectionUtil.findDirection;

public abstract class Bishop extends AbstractPiece {
    protected Bishop() {
        super();
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

    @Override
    public Set<A1Notation> getAllPossibleSquares() {
        return Sets.union(
                DirectionUtil.allPositionsInDirection(position, A1Notation::upLeft),
                DirectionUtil.allPositionsInDirection(position, A1Notation::downLeft),
                DirectionUtil.allPositionsInDirection(position, A1Notation::upRight),
                DirectionUtil.allPositionsInDirection(position, A1Notation::downRight)
        );
    }
}
