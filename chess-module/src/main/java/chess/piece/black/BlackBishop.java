package chess.piece.black;

import chess.match.MatchBoard;
import chess.piece.Bishop;

public class BlackBishop extends Bishop implements BlackPiece {

    public BlackBishop(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "BB";
    }

    @Override
    public String getHTMLCode() {
        return "&#9821;";
    }

    @Override
    public BlackBishop copy() {
        return new BlackBishop(null);
    }
}
