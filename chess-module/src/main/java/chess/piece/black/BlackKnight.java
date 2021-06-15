package chess.piece.black;

import chess.board.Board;
import chess.piece.Knight;

public class BlackKnight extends Knight implements BlackPiece {

    public BlackKnight() {
        super();
    }

    public BlackKnight(BlackKnight knight) {
        super(knight);
    }

    public BlackKnight(BlackKnight blackKnight, Board board) {
        super(blackKnight, board);
    }

    @Override
    public String toString() {
        return "♞";
    }

    @Override
    public String getHTMLCode() {
        return "&#9822;";
    }

    @Override
    public BlackKnight copyToBoard(Board board) {
        return new BlackKnight(this, board);
    }

}
