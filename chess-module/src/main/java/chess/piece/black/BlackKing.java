package chess.piece.black;

import chess.match.Board;
import chess.piece.King;

public class BlackKing extends King implements BlackPiece {

    public BlackKing(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "BK";
    }

    @Override
    public String getHTMLCode() {
        return "&#9818;";
    }
}
