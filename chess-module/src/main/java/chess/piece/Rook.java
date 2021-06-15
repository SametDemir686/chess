package chess.piece;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;
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

    @Override
    public Set<A1Notation> getAllPossibleSquares() {
        return Sets.union(
                allPositionsInDirection(position, A1Notation::up),
                allPositionsInDirection(position, A1Notation::left),
                allPositionsInDirection(position, A1Notation::down),
                allPositionsInDirection(position, A1Notation::right)
        );
    }
}
