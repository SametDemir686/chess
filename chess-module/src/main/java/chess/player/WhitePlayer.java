package chess.player;

import chess.piece.white.WhiteKing;
import chess.piece.white.WhitePiece;

public class WhitePlayer extends AbstractPlayer<WhitePiece, WhiteKing> {

    @Override
    public boolean isWhite() {
        return true;
    }
}
