package chess.board;

import chess.notations.Position;
import chess.piece.black.BlackPiece;
import chess.piece.white.WhitePiece;
import chess.player.Player;

public class HelperBoard extends AbstractClassicBoard {

    HelperBoard(Player<WhitePiece> whitePlayer, Player<BlackPiece> blackPlayer) {
        removeAllPieces();
        whitePlayer.getAllActivePieces().forEach(s -> putWhitePiece(s.getPosition(), s.copy()));
        blackPlayer.getAllActivePieces().forEach(s -> putBlackPiece(s.getPosition(), s.copy()));
    }

    @Override
    public void resetBoard() {
        removeAllPieces();
    }

    @Override
    public boolean canMove(Position piecePosition, Position newPosition) {
        return true;
    }

}
