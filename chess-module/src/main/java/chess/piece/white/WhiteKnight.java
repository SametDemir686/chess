package chess.piece.white;

import chess.board.Board;
import chess.piece.Knight;

public class WhiteKnight extends Knight implements WhitePiece {
    public WhiteKnight() {
        super();
    }

    public WhiteKnight(WhiteKnight whiteKnight, Board board) {
        super(whiteKnight, board);
    }

    public WhiteKnight(WhiteKnight knight) {
        super(knight);
    }

    @Override
    public String toString() {
        return "♘";
    }

    @Override
    public String getHTMLCode() {
        return "&#9816;";
    }

    @Override
    public WhiteKnight copyToBoard(Board board) {
        return new WhiteKnight(this, board);
    }
}
