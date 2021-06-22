package chess.move.whitesmove;

import chess.notations.Position;
import chess.piece.Piece;
import chess.piece.white.*;

import javax.validation.UnexpectedTypeException;

public class WhitesMove {
    public static final String SHORT_CASTLING_NOTATION = "O-O";
    public static final String LONG_CASTLING_NOTATION = "O-O-O";
    private final String notation;
    private final String notationUpperCase;
    private Position to;
    private Piece piece;

    public WhitesMove(String notation) {
        this.notation = notation;
        this.notationUpperCase = notation.toUpperCase();
        extractTO();
        extractPiece();
    }

    private void extractPiece() {
        if (isCastling()) return;
        if (isPromotion()) this.piece = new WhitePawn();
        if (notationUpperCase.charAt(0) == 'N')
            this.piece = new WhiteKnight();
        else if (notationUpperCase.charAt(0) == 'Q')
            this.piece = new WhiteQueen();
        else if (notationUpperCase.charAt(0) == 'B')
            this.piece = new WhiteBishop();
        else if (notationUpperCase.charAt(0) == 'K')
            this.piece = new WhiteKing();
        else if (notationUpperCase.charAt(0) == 'R')
            this.piece = new WhiteRook();
        else if (notation.charAt(0) >= 'a' || notation.charAt(0) <= 'h')
            this.piece = new WhitePawn();
        else
            throw new UnexpectedTypeException(notation);
    }

    private boolean isPromotion() {
        return notation.contains("=");
    }

    private boolean isCastling() {
        return isShortCastling()
                || isLongCastling();
    }

    private void extractTO() {
        if (isCastling()) return;
        if (isPromotion()) this.piece = new WhitePawn();
        to = Position.valueOf(getLastTwoChars(isPromotion() ? notationUpperCase.substring(0, notationUpperCase.length() - 2) : notationUpperCase));
    }

    private String getLastTwoChars(String name) {
        return name.substring(name.length() - 2);
    }

    public Position to() {
        return to;
    }

    public Piece piece() {
        return piece;
    }

    public boolean isCapture() {
        return notation.contains("x");
    }

    public boolean isShortCastling() {
        return notationUpperCase.equals(SHORT_CASTLING_NOTATION);
    }

    public boolean isLongCastling() {
        return notationUpperCase.equals(LONG_CASTLING_NOTATION);
    }

    public String distinguisher() {
        if (isCastling()) return null;
        if (isPromotion()) {
            return isCapture() ? notation.substring(0, 1) : null;
        }
        if (isCapture()) {
            if (notation.length() > 4)
                return notation.substring(1, notation.length() - 3);
        } else if (notation.length() > 3)
            return notation.substring(1, notation.length() - 2);
        return null;
    }
}
