package chess.player;

import chess.move.InvalidMove;
import chess.move.Move;
import chess.notations.Position;
import chess.notations.PromotionType;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Rook;
import chess.piece.white.WhiteKing;
import chess.piece.white.WhitePawn;
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
        king.move(C1);
        getPieceAt(A1).move(D1);
    }

    @Override
    public void castleShort() {
        king.move(G1);
        getPieceAt(H1).move(F1);
    }

    @Override
    public Move promote(Position position, PromotionType promotionType) {
        WhitePawn pawn = (WhitePawn) getPawnAt(position);
        remove(pawn);
        add(position, pawn.promoteToQueen());
        return new InvalidMove();
    }

    private Pawn getPawnAt(Position position) {
        return getPawns()
                .stream()
                .filter(s -> s.getPosition() == position)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("No pawn found at " + position));
    }
}
