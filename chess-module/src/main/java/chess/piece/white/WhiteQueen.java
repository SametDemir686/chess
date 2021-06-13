package chess.piece.white;

import chess.match.Board;
import chess.piece.Queen;

public class WhiteQueen extends Queen implements WhitePiece {
    public WhiteQueen(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "WQ";
    }

    @Override
    public String getHTMLCode() {
        return "&#9813;";
    }
}
