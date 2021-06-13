package chess.piece.white;

import chess.match.Board;
import chess.piece.Knight;

public class WhiteKnight extends Knight implements WhitePiece {
    public WhiteKnight(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "WH";
    }

    @Override
    public String getHTMLCode() {
        return "&#9816;";
    }
}
