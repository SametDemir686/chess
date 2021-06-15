package chess.player;

import chess.piece.black.BlackKing;
import chess.piece.black.BlackPiece;

public class BlackPlayer extends AbstractPlayer<BlackPiece, BlackKing> {

    @Override
    public boolean isWhite() {
        return false;
    }
}
