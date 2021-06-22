package chess.player;

import chess.piece.Piece;
import chess.piece.Rook;
import chess.piece.black.BlackKing;
import chess.piece.black.BlackPiece;

import static chess.notations.Position.*;

public class BlackPlayer extends AbstractPlayer<BlackPiece, BlackKing> {

    @Override
    public boolean isWhite() {
        return false;
    }

    @Override
    public boolean canLongCastle() {
        Piece rookA8 = getPieceAt(A8);
        return rookA8 instanceof Rook
                && !rookA8.hasMoved()
                && !king.hasMoved();
    }

    @Override
    public boolean canShortCastle() {
        Piece rookH8 = getPieceAt(H8);
        return rookH8 instanceof Rook
                && !rookH8.hasMoved()
                && !king.hasMoved();
    }

    @Override
    public void castleLong() {
        king.setPosition(C8);
        getPieceAt(A8).setPosition(D8);
    }

    @Override
    public void castleShort() {
        king.setPosition(G8);
        getPieceAt(H8).setPosition(F8);
    }
}
