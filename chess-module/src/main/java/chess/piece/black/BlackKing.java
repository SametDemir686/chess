package chess.piece.black;

import chess.match.MatchBoard;
import chess.piece.King;

public class BlackKing extends King implements BlackPiece {

    public BlackKing(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "BK";
    }

    @Override
    public String getHTMLCode() {
        return "&#9818;";
    }

    @Override
    public BlackKing copy() {
        return new BlackKing(null);
    }
}
