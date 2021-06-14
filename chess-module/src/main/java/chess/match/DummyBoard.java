package chess.match;

import chess.player.BlackPlayer;
import chess.player.WhitePlayer;

public class DummyBoard extends AbstractBoard {

    public DummyBoard(WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
        removeAllPieces();
        this.whitePlayer = new WhitePlayer(whitePlayer);
        this.blackPlayer = new BlackPlayer(blackPlayer);

        this.whitePlayer.getAllActivePieces().forEach(s -> put(s.getPosition(), s));
        this.blackPlayer.getAllActivePieces().forEach(s -> put(s.getPosition(), s));

        this.whitePlayer.setBoard(this);
        this.blackPlayer.setBoard(this);
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
