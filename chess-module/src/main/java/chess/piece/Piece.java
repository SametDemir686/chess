package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.move.Move;
import chess.notations.Position;

import java.util.Set;
import java.util.stream.Collectors;

public interface Piece {
    boolean canMoveTo(Position newPosition);

    Position getPosition();

    void setPosition(Position position);

    boolean isBlack();

    boolean isWhite();

    Move move(Position moveTo);

    boolean canTreathen(Direction direction);

    boolean threatens(Position position);

    void captured();

    boolean isActive();

    default boolean isCaptured() {
        return !isActive();
    }

    String getHTMLCode();

    void setBoard(Board board);

    default Piece copy() {
        return copyToBoard(null);
    }

    Piece copyToBoard(Board board);

    boolean isNotOccupiedByAllyPiece(Position newPosition);

    boolean isNotOccupiedByEnemyPiece(Position newPosition);

    boolean isOccupiedByAllyPiece(Position newPosition);

    boolean isOccupiedByEnemyPiece(Position newPosition);

    default Set<Position> getAllPossibleMoves() {
        return getAllPossibleSquares().stream().filter(this::canMoveTo).collect(Collectors.toSet());
    }

    Set<Position> getAllPossibleSquares();

    default boolean canMove() {
        return getAllPossibleSquares().stream().anyMatch(this::canMoveTo);
    }

    default boolean isPromotable() {
        return false;
    }

    boolean distinguish(String distinguisher);

    boolean hasMoved();

    Board getBoard();
}
