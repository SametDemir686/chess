package chess.piece.black;

import chess.match.Board;
import chess.piece.Rook;

public class BlackRook extends Rook implements BlackPiece {

    public BlackRook(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "BR";
    }

    @Override
    public String getHTMLCode() {
        return "&#9820;";
    }
}
