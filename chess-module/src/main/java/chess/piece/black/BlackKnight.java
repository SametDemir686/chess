package chess.piece.black;

import chess.match.Board;
import chess.piece.Knight;

public class BlackKnight extends Knight implements BlackPiece {

    public BlackKnight(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "BH";
    }

    @Override
    public String getHTMLCode() {
        return "&#9822;";
    }
}
