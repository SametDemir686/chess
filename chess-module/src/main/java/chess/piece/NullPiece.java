package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

public class NullPiece extends AbstractPiece {
    public NullPiece(Board matchBoard) {
        super(matchBoard);
    }

    public NullPiece(NullPiece nullPiece, Board board) {
        super(nullPiece, board);
    }

    @Override
    public String toString() {
        return "__";
    }

    @Override
    public boolean canMoveTo(A1Notation newPosition) {
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
    public boolean threatens(A1Notation position) {
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

}
