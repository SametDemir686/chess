package chess.player;

import chess.match.A1Notation;
import chess.piece.King;
import chess.piece.Piece;

import java.util.List;

public interface Player<P extends Piece> {
    List<P> getAllActivePieces();

    List<P> getAllPieces();

    King getKing();

    default A1Notation getKingsPosition() {
        return getKing().getPosition();
    }

    boolean isWhite();

    void add(A1Notation position, P piece);

    boolean remove(P piece);
}
