package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;

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
        return direction.isValid();
    }

    private boolean hasALookAt(Position to) {
        Direction direction = findDirection(position, to);
        return canTreathen(direction);
    }

    @Override
    public Set<Position> getAllPossibleSquares() {
        return getAllDirections().stream()
                .map(direction -> allPositionsInDirection(position, direction))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
