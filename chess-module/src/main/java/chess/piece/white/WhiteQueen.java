package chess.piece.white;

import chess.board.Board;
import chess.piece.Queen;

public class WhiteQueen extends Queen implements WhitePiece {
    public WhiteQueen() {
        super();
    }

    public WhiteQueen(WhiteQueen whiteQueen, Board board) {
        super(whiteQueen, board);
    }

    public WhiteQueen(WhiteQueen queen) {
        super(queen);
    }

    @Override
    public String toString() {
        return "♕";
    }

    @Override
    public String getHTMLCode() {
        return "&#9813;";
    }

    @Override
    public WhiteQueen copyToBoard(Board board) {
        return new WhiteQueen(this, board);
    }

}
