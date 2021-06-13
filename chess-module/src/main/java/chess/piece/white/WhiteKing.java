package chess.piece.white;

import chess.match.Board;
import chess.piece.King;

public class WhiteKing extends King implements WhitePiece {
    public WhiteKing(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "WK";
    }

    @Override
    public String getHTMLCode() {
        return "&#9812;";
    }
}
