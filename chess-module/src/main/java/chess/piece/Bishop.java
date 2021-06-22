package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;
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
    public boolean canMoveTo(Position newPosition) {
        if (!super.canMoveTo(newPosition)) return false;
        return threatens(newPosition);
    }

    @Override
    public boolean threatens(Position position) {
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

    private boolean hasALookAt(Position at) {
        Direction direction = findDirection(position, at);
        return canTreathen(direction);
    }

    @Override
    public Set<Position> getAllPossibleSquares() {
        return Sets.union(
                DirectionUtil.allPositionsInDirection(position, Position::upLeft),
                DirectionUtil.allPositionsInDirection(position, Position::downLeft),
                DirectionUtil.allPositionsInDirection(position, Position::upRight),
                DirectionUtil.allPositionsInDirection(position, Position::downRight)
        );
    }
}
