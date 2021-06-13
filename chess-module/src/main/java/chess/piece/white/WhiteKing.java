package chess.piece.white;

import chess.match.MatchBoard;
import chess.piece.King;

public class WhiteKing extends King implements WhitePiece {
    public WhiteKing(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "WK";
    }

    @Override
    public String getHTMLCode() {
        return "&#9812;";
    }

    @Override
    public WhiteKing copy() {
        return new WhiteKing(null);
    }
}
