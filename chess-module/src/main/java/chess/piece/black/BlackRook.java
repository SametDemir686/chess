package chess.piece.black;

import chess.board.Board;
import chess.piece.Rook;

public class BlackRook extends Rook implements BlackPiece {

    public BlackRook() {
        super();
    }

    public BlackRook(BlackRook rook) {
        super(rook);
    }

    public BlackRook(BlackRook blackRook, Board board) {
        super(blackRook, board);
    }

    @Override
    public String toString() {
        return "♜";
    }

    @Override
    public String getHTMLCode() {
        return "&#9820;";
    }

    @Override
    public BlackRook copyToBoard(Board board) {
        return new BlackRook(this, board);
    }

}
