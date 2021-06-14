package chess.piece.black;

import chess.match.Board;
import chess.piece.Knight;

public class BlackKnight extends Knight implements BlackPiece {

    public BlackKnight(Board board) {
        super(board);
    }

    public BlackKnight(BlackKnight knight) {
        super(knight);
    }

    public BlackKnight(BlackKnight blackKnight, Board board) {
        super(blackKnight, board);
    }

    @Override
    public String toString() {
        return "BH";
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
