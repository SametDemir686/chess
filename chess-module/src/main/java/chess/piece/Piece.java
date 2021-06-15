package chess.piece;

import chess.board.Board;
import chess.match.A1Notation;
import chess.match.Direction;

import java.util.Set;
import java.util.stream.Collectors;

public interface Piece {
    boolean canMoveTo(A1Notation newPosition);

    A1Notation getPosition();

    void setPosition(A1Notation position);

    boolean isBlack();

    boolean isWhite();

    void move();

    boolean canTreathen(Direction direction);

    boolean threatens(A1Notation position);

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

    boolean isNotOccupiedByAllyPiece(A1Notation newPosition);

    boolean isNotOccupiedByEnemyPiece(A1Notation newPosition);

    boolean isOccupiedByAllyPiece(A1Notation newPosition);

    boolean isOccupiedByEnemyPiece(A1Notation newPosition);

    default Set<A1Notation> getAllPossibleMoves() {
        return getAllPossibleSquares().stream().filter(this::canMoveTo).collect(Collectors.toSet());
    }

    Set<A1Notation> getAllPossibleSquares();

    default boolean canMove() {
        return getAllPossibleSquares().stream().anyMatch(this::canMoveTo);
    }

    default boolean isPromotable() {
        return false;
    }

}
