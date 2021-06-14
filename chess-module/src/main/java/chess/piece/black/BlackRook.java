package chess.piece.black;

import chess.match.Board;
import chess.piece.Rook;

public class BlackRook extends Rook implements BlackPiece {

    public BlackRook(Board board) {
        super(board);
    }

    public BlackRook(BlackRook rook) {
        super(rook);
    }

    public BlackRook(BlackRook blackRook, Board board) {
        super(blackRook, board);
    }

    @Override
    public String toString() {
        return "BR";
    }

    @Override
    public String getHTMLCode() {
        return "&#9820;";
    }

    @Override
    public BlackRook copyToBoard(Board board) {
        return new BlackRook(this, board);
    }

}
