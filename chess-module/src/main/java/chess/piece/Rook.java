package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;
import chess.util.Sets;

import java.util.Set;

import static chess.util.DirectionUtil.allPositionsInDirection;
import static chess.util.DirectionUtil.findDirection;

public abstract class Rook extends AbstractPiece {
    protected Rook() {
        super();
    }

    protected Rook(Rook rook) {
        super(rook);
    }

    protected Rook(Rook rook, Board board) {
        super(rook, board);
    }

    @Override
    public boolean canMoveTo(Position newPosition) {
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
    public boolean threatens(Position position) {
        return canTreathen(findDirection(this.position, position))
                && isDirectionNotBlocked(position);
    }

    @Override
    public Set<Position> getAllPossibleSquares() {
        return Sets.union(
                allPositionsInDirection(position, Position::up),
                allPositionsInDirection(position, Position::left),
                allPositionsInDirection(position, Position::down),
                allPositionsInDirection(position, Position::right)
        );
    }
}
