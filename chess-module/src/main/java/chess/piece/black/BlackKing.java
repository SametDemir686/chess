package chess.piece.black;

import chess.match.Board;
import chess.piece.King;

public class BlackKing extends King implements BlackPiece {

    public BlackKing(Board board) {
        super(board);
    }

    public BlackKing(BlackKing king) {
        super(king);
    }

    public BlackKing(BlackKing blackKing, Board board) {
        super(blackKing, board);
    }

    @Override
    public String toString() {
        return "BK";
    }

    @Override
    public String getHTMLCode() {
        return "&#9818;";
    }

    @Override
    public BlackKing copyToBoard(Board board) {
        return new BlackKing(this, board);
    }

}
