package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.move.InvalidMove;
import chess.move.Move;
import chess.notations.Position;

import java.util.function.UnaryOperator;

import static chess.util.DirectionUtil.findDirection;
import static chess.util.DirectionUtil.parseToUnaryOperator;

public abstract class AbstractPiece implements Piece {
    protected Board board;
    protected Position position;
    protected boolean active = true;
    protected boolean moved = false;

    protected AbstractPiece() {
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

    protected AbstractPiece(Position position) {
        this();
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean canMoveTo(Position newPosition) {
        return !isCaptured()
                && isNotOccupiedByAllyPiece(newPosition)
                && !board.willThereBeCheckIfMoves(this.position, newPosition);
    }

    @Override
    public boolean hasMoved() {
        return moved;
    }

    public Move move(Position to) {
        this.moved = true;
        this.position = to;
        return new InvalidMove();
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
    public boolean isNotOccupiedByAllyPiece(Position newPosition) {
        return !isOccupiedByAllyPiece(newPosition);
    }

    @Override
    public boolean isNotOccupiedByEnemyPiece(Position newPosition) {
        return !isOccupiedByEnemyPiece(newPosition);
    }

    @Override
    public boolean isOccupiedByAllyPiece(Position newPosition) {
        return !board.isEmpty(newPosition)
                && isWhite() == board.getPieceAt(newPosition).isWhite();
    }

    @Override
    public boolean isOccupiedByEnemyPiece(Position newPosition) {
        return !board.isEmpty(newPosition)
                && isWhite() != board.getPieceAt(newPosition).isWhite();
    }

    public boolean isTreathenedByEnemyPiece(Position newPosition) {
        if (isWhite()) return board.isThreatenedByBlack(newPosition);
        return board.isThreatenedByWhite(newPosition);
    }

    public boolean isDirectionNotBlocked(Position position) {
        Direction direction = findDirection(this.position, position);
        UnaryOperator<Position> director = parseToUnaryOperator(direction);
        return direction.isValid()
                && isDirectionNotBlocked(position, director);
    }

    private boolean isDirectionNotBlocked(Position position, UnaryOperator<Position> direction) {
        return findFirstBlockingSquare(position, direction) == position;
    }

    private Position findFirstBlockingSquare(Position newPosition, UnaryOperator<Position> direction) {
        Position current = direction.apply(position);
        while (current != null && current != newPosition && board.isEmpty(current)) {
            current = direction.apply(current);
        }
        return current;
    }

    public boolean distinguish(String distinguisher) {
        if (distinguisher == null) return true;
        return position.toString().contains(distinguisher.toUpperCase());
    }
}
