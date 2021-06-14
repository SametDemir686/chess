package chess.piece;

import chess.match.Board;

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
}
