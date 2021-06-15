package chess.board;

import chess.match.A1Notation;
import chess.piece.black.BlackPiece;
import chess.piece.white.WhitePiece;
import chess.player.Player;

public class FreeBoard extends AbstractClassicBoard {

    public FreeBoard() {
        removeAllPieces();
        whitesTurn = true;
    }

    public FreeBoard(Player<WhitePiece> whitePlayer, Player<BlackPiece> blackPlayer, boolean whitesTurn) {
        this();
        whitePlayer.getAllPieces().forEach(s -> putWhitePiece(s.getPosition(), s));
        blackPlayer.getAllPieces().forEach(s -> putBlackPiece(s.getPosition(), s));
        super.whitesTurn = whitesTurn;
    }

    public FreeBoard(boolean whitesTurn) {
        removeAllPieces();
        this.whitesTurn = whitesTurn;
    }

    @Override
    public void resetBoard() {
        removeAllPieces();
        whitesTurn = true;
    }

    @Override
    public boolean canMove(A1Notation piecePosition, A1Notation newPosition) {
        return getPieceAt(piecePosition).canMoveTo(newPosition);
    }

}
