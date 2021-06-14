package chess.piece.black;

import chess.match.Board;
import chess.piece.Bishop;

public class BlackBishop extends Bishop implements BlackPiece {

    public BlackBishop(Board board) {
        super(board);
    }

    public BlackBishop(BlackBishop blackBishop) {
        super(blackBishop);
    }

    public BlackBishop(BlackBishop blackBishop, Board board) {
        super(blackBishop, board);
    }

    @Override
    public String toString() {
        return "BB";
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
