package chess.piece.white;

import chess.match.Board;
import chess.piece.Bishop;

public class WhiteBishop extends Bishop implements WhitePiece {

    public WhiteBishop(Board board) {
        super(board);
    }

    public WhiteBishop(WhiteBishop whiteBishop, Board board) {
        super(whiteBishop, board);
    }

    public WhiteBishop(WhiteBishop bishop) {
        super(bishop);
    }

    @Override
    public String toString() {
        return "WB";
    }

    @Override
    public String getHTMLCode() {
        return "&#9815;";
    }

    @Override
    public WhiteBishop copyToBoard(Board board) {
        return new WhiteBishop(this, board);
    }

}
