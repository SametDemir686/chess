package chess.piece.white;

import chess.match.MatchBoard;
import chess.piece.Bishop;

public class WhiteBishop extends Bishop implements WhitePiece {

    public WhiteBishop(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "WB";
    }

    @Override
    public String getHTMLCode() {
        return "&#9815;";
    }

    @Override
    public WhiteBishop copy() {
        return new WhiteBishop(null);
    }
}
