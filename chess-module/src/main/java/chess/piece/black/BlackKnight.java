package chess.piece.black;

import chess.match.MatchBoard;
import chess.piece.Knight;

public class BlackKnight extends Knight implements BlackPiece {

    public BlackKnight(MatchBoard matchBoard) {
        super(matchBoard);
    }

    @Override
    public String toString() {
        return "BH";
    }

    @Override
    public String getHTMLCode() {
        return "&#9822;";
    }

    @Override
    public BlackKnight copy() {
        return new BlackKnight(null);
    }
}
