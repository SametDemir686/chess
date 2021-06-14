package chess.piece.white;

import chess.match.Board;
import chess.piece.King;

public class WhiteKing extends King implements WhitePiece {
    public WhiteKing(Board board) {
        super(board);
    }

    public WhiteKing(WhiteKing whiteKing, Board board) {
        super(whiteKing, board);
    }

    public WhiteKing(WhiteKing king) {
        super(king);
    }

    @Override
    public String toString() {
        return "WK";
    }

    @Override
    public String getHTMLCode() {
        return "&#9812;";
    }

    @Override
    public WhiteKing copyToBoard(Board board) {
        return new WhiteKing(this, board);
    }

}
