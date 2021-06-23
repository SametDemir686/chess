package chess.player;

import chess.move.InvalidMove;
import chess.move.Move;
import chess.notations.Position;
import chess.notations.PromotionType;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Rook;
import chess.piece.black.BlackKing;
import chess.piece.black.BlackPawn;
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
        king.move(C8);
        getPieceAt(A8).move(D8);
    }

    @Override
    public void castleShort() {
        king.move(G8);
        getPieceAt(H8).move(F8);
    }

    @Override
    public Move promote(Position position, PromotionType promotionType) {
        BlackPawn pawn = (BlackPawn) getPawnAt(position);
        remove(pawn);
        add(position, (BlackPiece) pawn.promote(promotionType));
        return new InvalidMove();
    }

    private Pawn getPawnAt(Position position) {
        return getPawns()
                .stream()
                .filter(pawn -> pawn.getPosition() == position)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("No pawn found at " + position));
    }
}
