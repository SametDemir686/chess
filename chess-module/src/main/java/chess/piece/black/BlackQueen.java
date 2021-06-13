package chess.piece.black;

import chess.match.Board;
import chess.piece.Queen;

public class BlackQueen extends Queen implements BlackPiece {

    public BlackQueen(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "BQ";
    }

    @Override
    public String getHTMLCode() {
        return "&#9819;";
    }
}
