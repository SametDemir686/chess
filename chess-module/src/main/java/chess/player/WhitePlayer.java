package chess.player;

import chess.piece.Piece;
import chess.piece.Rook;
import chess.piece.white.WhiteKing;
import chess.piece.white.WhitePiece;

import static chess.notations.Position.*;

public class WhitePlayer extends AbstractPlayer<WhitePiece, WhiteKing> {

    @Override
    public boolean isWhite() {
        return true;
    }

    @Override
    public boolean canLongCastle() {
        Piece pieceAt = getPieceAt(A1);
        return pieceAt instanceof Rook
                && !pieceAt.hasMoved()
                && !king.hasMoved();
    }

    @Override
    public boolean canShortCastle() {
        Piece pieceAt = getPieceAt(H1);
        return pieceAt instanceof Rook
                && !pieceAt.hasMoved()
                && !king.hasMoved();
    }

    @Override
    public void castleLong() {
        king.setPosition(C1);
        getPieceAt(A1).setPosition(D1);
    }

    @Override
    public void castleShort() {
        king.setPosition(G1);
        getPieceAt(H1).setPosition(F1);
    }
}
