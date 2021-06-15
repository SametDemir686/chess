package chess.piece.white;

import chess.board.Board;
import chess.piece.Rook;

public class WhiteRook extends Rook implements WhitePiece {
    public WhiteRook() {
        super();
    }

    public WhiteRook(WhiteRook whiteRook, Board board) {
        super(whiteRook, board);
    }

    public WhiteRook(WhiteRook rook) {
        super(rook);
    }

    @Override
    public String toString() {
        return "♖";
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
