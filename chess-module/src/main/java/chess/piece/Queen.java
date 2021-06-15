package chess.piece;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static chess.util.DirectionUtil.*;

public abstract class Queen extends AbstractPiece {

    protected Queen() {
        super();
    }

    protected Queen(Queen queen) {
        super(queen);
    }

    protected Queen(Queen queen, Board board) {
        super(queen, board);
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

    @Override
    public Set<A1Notation> getAllPossibleSquares() {
        return getAllDirections().stream()
                .map(direction -> allPositionsInDirection(position, direction))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
