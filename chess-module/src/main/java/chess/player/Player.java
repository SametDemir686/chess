package chess.player;

import chess.notations.Position;
import chess.piece.King;
import chess.piece.NullPiece;
import chess.piece.Piece;

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
}
