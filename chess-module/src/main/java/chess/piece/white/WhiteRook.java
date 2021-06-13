package chess.piece.white;

import chess.match.MatchBoard;
import chess.piece.Rook;

public class WhiteRook extends Rook implements WhitePiece {
    public WhiteRook(MatchBoard matchBoard) {
        super(matchBoard);
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
    public WhiteRook copy() {
        return new WhiteRook(null);
    }
}
