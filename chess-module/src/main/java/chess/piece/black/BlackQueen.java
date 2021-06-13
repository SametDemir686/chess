package chess.piece.black;

import chess.match.MatchBoard;
import chess.piece.Queen;

public class BlackQueen extends Queen implements BlackPiece {

    public BlackQueen(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "BQ";
    }

    @Override
    public String getHTMLCode() {
        return "&#9819;";
    }

    @Override
    public BlackQueen copy() {
        return new BlackQueen(null);
    }
}
