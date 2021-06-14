package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import java.util.function.UnaryOperator;

import static chess.util.DirectionUtil.findDirection;
import static chess.util.DirectionUtil.parseToUnaryOperator;

public abstract class AbstractPiece implements Piece {
    protected Board board;
    protected A1Notation position;
    protected boolean active = true;
    protected boolean moved = false;

    protected AbstractPiece(Board board) {
        this.board = board;
    }

    protected AbstractPiece(AbstractPiece piece) {
        position = piece.position;
        active = piece.active;
        moved = piece.moved;
    }

    protected AbstractPiece(AbstractPiece piece, Board board) {
        this(piece);
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
        return !board.willThereBeCheckIfMoves(this.position, newPosition)
                && isNotOccupiedByAllyPiece(newPosition);
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

    @Override
    public void setBoard(Board board) {
        if (this.board == board) return;
        if (this.board == null) this.board = board;
        else throw new IllegalStateException("Cannot change board because it is already assigned");
    }

    public void captured() {
        this.active = false;
        this.position = null;
    }

    @Override
    public boolean isNotOccupiedByAllyPiece(A1Notation newPosition) {
        return !isOccupiedByAllyPiece(newPosition);
    }

    @Override
    public boolean isNotOccupiedByEnemyPiece(A1Notation newPosition) {
        return !isOccupiedByEnemyPiece(newPosition);
    }

    @Override
    public boolean isOccupiedByAllyPiece(A1Notation newPosition) {
        return !board.isEmpty(newPosition)
                && isWhite() == board.getPieceAt(newPosition).isWhite();
    }

    @Override
    public boolean isOccupiedByEnemyPiece(A1Notation newPosition) {
        return !board.isEmpty(newPosition)
                && isWhite() != board.getPieceAt(newPosition).isWhite();
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
