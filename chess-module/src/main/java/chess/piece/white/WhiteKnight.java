package chess.piece.white;

import chess.match.MatchBoard;
import chess.piece.Knight;

public class WhiteKnight extends Knight implements WhitePiece {
    public WhiteKnight(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "WH";
    }

    @Override
    public String getHTMLCode() {
        return "&#9816;";
    }

    @Override
    public WhiteKnight copy() {
        return new WhiteKnight(null);
    }
}
