package chess.piece.black;

import chess.match.Board;
import chess.piece.Bishop;

public class BlackBishop extends Bishop implements BlackPiece {

    public BlackBishop(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "BB";
    }

    @Override
    public String getHTMLCode() {
        return "&#9821;";
    }
}
