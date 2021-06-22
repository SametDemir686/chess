package chess.piece;

import chess.board.Board;
import chess.match.Direction;
import chess.notations.Position;

import java.util.HashSet;
import java.util.Set;

public class NullPiece extends AbstractPiece {
    public NullPiece() {
        super();
    }

    public NullPiece(NullPiece nullPiece, Board board) {
        super(nullPiece, board);
    }

    @Override
    public String toString() {
        return "__";
    }

    @Override
    public boolean canMoveTo(Position newPosition) {
        return false;
    }

    @Override
    public boolean isBlack() {
        return false;
    }

    @Override
    public boolean isWhite() {
        return false;
    }

    @Override
    public boolean canTreathen(Direction direction) {
        return false;
    }

    @Override
    public boolean threatens(Position position) {
        return false;
    }

    @Override
    public String getHTMLCode() {
        return null;
    }

    @Override
    public Piece copyToBoard(Board board) {
        return new NullPiece(this, board);
    }

    @Override
    public Set<Position> getAllPossibleSquares() {
        return new HashSet<>();
    }
}
