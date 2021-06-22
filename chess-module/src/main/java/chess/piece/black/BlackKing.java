package chess.piece.black;

import chess.board.Board;
import chess.notations.Position;
import chess.piece.King;

public class BlackKing extends King implements BlackPiece {

    public BlackKing() {
        super();
    }

    public BlackKing(BlackKing king) {
        super(king);
    }

    public BlackKing(BlackKing blackKing, Board board) {
        super(blackKing, board);
    }

    public BlackKing(Position position, Board board) {
        super(position, board);
    }

    @Override
    public String toString() {
        return "♚";
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
