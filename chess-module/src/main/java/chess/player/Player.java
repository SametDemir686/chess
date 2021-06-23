package chess.player;

import chess.move.Move;
import chess.notations.Position;
import chess.notations.PromotionType;
import chess.piece.*;

import java.util.List;

public interface Player<P extends Piece> {
    List<P> getAllActivePieces();

    List<P> getAllPieces();

    King getKing();

    default Position getKingsPosition() {
        return getKing().getPosition();
    }

    boolean isWhite();

    void add(Position position, P piece);

    boolean remove(P piece);

    Piece getPieceAt(Position position);

    default boolean hasPieceAt(Position position) {
        return !(getPieceAt(position) instanceof NullPiece);
    }

    void removeAllPieces();

    List<Pawn> getPawns();

    List<Queen> getQueens();

    List<Knight> getKnights();

    List<Bishop> getBishops();

    List<Rook> getRooks();

    boolean canLongCastle();

    boolean canShortCastle();

    void castleLong();

    void castleShort();

    boolean threathens(Position position);

    Move promote(Position promotingPosition, PromotionType promotionType);
}
