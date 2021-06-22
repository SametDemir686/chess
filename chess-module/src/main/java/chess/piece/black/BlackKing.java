package chess.piece.black;

import chess.board.Board;
import chess.notations.Position;
import chess.piece.King;

public class BlackKing extends King implements BlackPiece {

    public BlackKing() {
        super();
    }

    public BlackKing(Position position) {
        super(position);
    }

    @Override
    public boolean canShortCastle() {
        return board.canBlackShortCastle();
    }

    @Override
    public boolean canLongCastle() {
        return board.canBlackLongCastle();
    }

    @Override
    public boolean isShortCastling(Position newPosition) {
        return newPosition == Position.G8;
    }

    public BlackKing(BlackKing king) {
        super(king);
    }

    public BlackKing(BlackKing blackKing, Board board) {
        super(blackKing, board);
    }

    @Override
    public boolean isLongCastling(Position newPosition) {
        return newPosition == Position.C8;
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
