package chess.piece.white;

import chess.match.Board;
import chess.piece.Rook;

public class WhiteRook extends Rook implements WhitePiece {
    public WhiteRook(Board board) {
        super(board);
    }

    @Override
    public String toString() {
        return "WR";
    }

    @Override
    public String getHTMLCode() {
        return "&#9814;";
    }
}
