package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import java.util.function.UnaryOperator;

import static chess.util.Util.findDirection;
import static chess.util.Util.parseToUnaryOperator;

public abstract class AbstractPiece implements Piece {
    protected final Board board;
    protected A1Notation position;
    private boolean active = true;
    private boolean moved = false;

    protected AbstractPiece(Board board) {
        this.board = board;
    }

    @Override
    public A1Notation getPosition() {
        return position;
    }

    @Override
    public void setPosition(A1Notation position) {
        this.position = position;
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
        return !isPinned()
                && isNotOccupiedByAllyPiece(newPosition);
    }

    public boolean isPinned() {
        Direction directionToTheKing = findDirectionToTheKing();
        if (!directionToTheKing.isValid()) return false;
        return isThereNoPieceBetweenKingAndThisPiece(directionToTheKing)
                && isDirectionThreatened(directionToTheKing);
    }

    private Direction findDirectionToTheKing() {
        A1Notation kingsPosition = board.getKingsPosition(isWhite());
        return findDirection(position, kingsPosition);
    }

    private boolean isDirectionThreatened(Direction directionToTheKing) {
        A1Notation current = position;
        UnaryOperator<A1Notation> director = parseToUnaryOperator(directionToTheKing.reverse());
        while (current != null) {
            current = director.apply(position);
            if (board.isNotEmpty(current) && board.getPieceAt(current).canTreathen(directionToTheKing)) {
                return false;
            }
        }
        return true;
    }

    private boolean isThereNoPieceBetweenKingAndThisPiece(Direction directionToTheKing) {
        A1Notation kingsPosition = board.getKingsPosition(isWhite());
        UnaryOperator<A1Notation> director = parseToUnaryOperator(directionToTheKing);
        A1Notation current = position;
        while (current != kingsPosition) {
            current = director.apply(current);
            if (board.isNotEmpty(current)) break;
        }
        return current == kingsPosition;
    }

    public boolean hasMoved() {
        return moved;
    }

    public void move() {
        this.moved = true;
    }

    public boolean isActive() {
        return active;
    }

    public void captured() {
        this.active = false;
    }

    public boolean isNotOccupiedByAllyPiece(A1Notation newPosition) {
        return isWhite() != board.getPieceAt(newPosition).isWhite()
                || isBlack() != board.getPieceAt(newPosition).isBlack();
    }

    public boolean isTreathenedByEnemyPiece(A1Notation newPosition) {
        if (isWhite()) return board.isThreatenedByBlack(newPosition);
        return board.isThreatenedByWhite(newPosition);
    }

    public boolean isDirectionNotBlocked(A1Notation position) {
        Direction direction = findDirection(this.position, position);
        UnaryOperator<A1Notation> director = parseToUnaryOperator(direction);
        return direction.isValid()
                && isDirectionNotBlocked(position, director);
    }

    private boolean isDirectionNotBlocked(A1Notation position, UnaryOperator<A1Notation> direction) {
        return findFirstBlockingSquare(position, direction) == position;
    }

    private A1Notation findFirstBlockingSquare(A1Notation newPosition, UnaryOperator<A1Notation> direction) {
        A1Notation current = direction.apply(position);
        while (current != null && current != newPosition && board.isEmpty(current)) {
            current = direction.apply(current);
        }
        return current;
    }
}
