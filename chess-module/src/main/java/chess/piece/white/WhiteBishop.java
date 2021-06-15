package chess.piece.white;

import chess.board.Board;
import chess.piece.Bishop;

public class WhiteBishop extends Bishop implements WhitePiece {

    public WhiteBishop() {
        super();
    }

    public WhiteBishop(WhiteBishop whiteBishop, Board board) {
        super(whiteBishop, board);
    }

    public WhiteBishop(WhiteBishop bishop) {
        super(bishop);
    }

    @Override
    public String toString() {
        return "♗";
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
