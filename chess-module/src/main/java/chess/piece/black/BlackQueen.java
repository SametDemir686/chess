package chess.piece.black;

import chess.board.Board;
import chess.piece.Queen;

public class BlackQueen extends Queen implements BlackPiece {

    public BlackQueen() {
        super();
    }

    public BlackQueen(BlackQueen queen) {
        super(queen);
    }

    public BlackQueen(BlackQueen blackQueen, Board board) {
        super(blackQueen, board);
    }

    @Override
    public String toString() {
        return "♛";
    }

    @Override
    public String getHTMLCode() {
        return "&#9819;";
    }

    @Override
    public BlackQueen copyToBoard(Board board) {
        return new BlackQueen(this, board);
    }

}
