package chess.match;

import chess.piece.Piece;
import chess.player.BlackPlayer;
import chess.player.WhitePlayer;

public class DummyBoard extends AbstractBoard {

    public DummyBoard(Piece[][] board, WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
        this.board = board;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                piece.setBoard(this);
            }
        }
    }

    @Override
    public void initializeBoard() {

    }

    @Override
    public void resetBoard() {
        removeAllPieces();
    }

    @Override
    public boolean canMove(A1Notation piecePosition, A1Notation newPosition) {
        return true;
    }

}
