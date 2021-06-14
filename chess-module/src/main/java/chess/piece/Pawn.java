package chess.piece;

import chess.match.A1Notation;
import chess.match.Board;
import chess.match.Direction;

import static chess.util.Util.findDirection;
import static chess.util.Util.findMagnitudeSquare;

public abstract class Pawn extends AbstractPiece {
    protected Pawn(Board board) {
        super(board);
    }

    protected Pawn(Pawn aPawn) {
        super(aPawn);
    }

    protected Pawn(Pawn pawn, Board board) {
        super(pawn, board);
    }

    @Override
    public boolean threatens(A1Notation position) {
        Direction direction = findDirection(this.position, position);
        int magnitudeSquare = findMagnitudeSquare(this.position, position);
        return canTreathen(direction) && magnitudeSquare == 2;
    }
}
