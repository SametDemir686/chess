package chess.piece.black;

import chess.match.MatchBoard;
import chess.piece.Rook;

public class BlackRook extends Rook implements BlackPiece {

    public BlackRook(MatchBoard matchBoard) {
        super(matchBoard);
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
    public BlackRook copy() {
        return new BlackRook(null);
    }
}
