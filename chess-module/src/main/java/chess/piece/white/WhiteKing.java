package chess.piece.white;

import chess.board.Board;
import chess.notations.Position;
import chess.piece.King;

public class WhiteKing extends King implements WhitePiece {
    public WhiteKing() {
        super();
    }

    public WhiteKing(Position position, Board board) {
        super(position);
    }

    @Override
    public boolean canShortCastle() {
        return board.canWhiteShortCastle();
    }

    @Override
    public boolean canLongCastle() {
        return board.canWhiteLongCastle();
    }

    @Override
    public boolean isShortCastling(Position newPosition) {
        return newPosition == Position.G1;
    }

    public WhiteKing(WhiteKing whiteKing, Board board) {
        super(whiteKing, board);
    }

    public WhiteKing(WhiteKing king) {
        super(king);
    }

    @Override
    public boolean isLongCastling(Position newPosition) {
        return newPosition == Position.C1;
    }

    @Override
    public String toString() {
        return "♔";
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
