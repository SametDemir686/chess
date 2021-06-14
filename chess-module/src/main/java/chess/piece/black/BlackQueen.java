package chess.piece.black;

import chess.match.Board;
import chess.piece.Queen;

public class BlackQueen extends Queen implements BlackPiece {

    public BlackQueen(Board board) {
        super(board);
    }

    public BlackQueen(BlackQueen queen) {
        super(queen);
    }

    public BlackQueen(BlackQueen blackQueen, Board board) {
        super(blackQueen, board);
    }

    @Override
    public String toString() {
        return "BQ";
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
