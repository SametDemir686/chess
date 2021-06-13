package chess.piece.white;

import chess.match.MatchBoard;
import chess.piece.Queen;

public class WhiteQueen extends Queen implements WhitePiece {
    public WhiteQueen(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "WQ";
    }

    @Override
    public String getHTMLCode() {
        return "&#9813;";
    }

    @Override
    public WhiteQueen copy() {
        return new WhiteQueen(null);
    }
}
