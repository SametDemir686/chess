package chess.piece.white;

import chess.match.Board;
import chess.piece.Knight;

public class WhiteKnight extends Knight implements WhitePiece {
    public WhiteKnight(Board board) {
        super(board);
    }

    public WhiteKnight(WhiteKnight whiteKnight, Board board) {
        super(whiteKnight, board);
    }

    public WhiteKnight(WhiteKnight knight) {
        super(knight);
    }

    @Override
    public String toString() {
        return "WH";
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
