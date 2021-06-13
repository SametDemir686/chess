package chess.piece.white;

import chess.match.Board;
import chess.piece.Bishop;

public class WhiteBishop extends Bishop implements WhitePiece {

    public WhiteBishop(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "WB";
    }

    @Override
    public String getHTMLCode() {
        return "&#9815;";
    }
}
