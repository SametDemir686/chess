package chess.piece.black;

import chess.board.Board;
import chess.piece.Bishop;

public class BlackBishop extends Bishop implements BlackPiece {

    public BlackBishop() {
        super();
    }

    public BlackBishop(BlackBishop blackBishop) {
        super(blackBishop);
    }

    public BlackBishop(BlackBishop blackBishop, Board board) {
        super(blackBishop, board);
    }

    @Override
    public String toString() {
        return "♝";
    }

    @Override
    public String getHTMLCode() {
        return "&#9821;";
    }

    @Override
    public BlackBishop copyToBoard(Board board) {
        return new BlackBishop(this, board);
    }

}
