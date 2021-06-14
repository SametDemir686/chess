package chess.piece.white;

import chess.match.Board;
import chess.piece.Rook;

public class WhiteRook extends Rook implements WhitePiece {
    public WhiteRook(Board board) {
        super(board);
    }

    public WhiteRook(WhiteRook whiteRook, Board board) {
        super(whiteRook, board);
    }

    public WhiteRook(WhiteRook rook) {
        super(rook);
    }

    @Override
    public String toString() {
        return "WR";
    }

    @Override
    public String getHTMLCode() {
        return "&#9814;";
    }

    @Override
    public WhiteRook copyToBoard(Board board) {
        return new WhiteRook(this, board);
    }

}
