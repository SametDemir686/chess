package chess.piece;

import chess.match.A1Notation;

public class PieceDTO {

    private boolean black;
    private boolean white;
    private boolean active;
    private boolean captured;
    private A1Notation position;
    private String htmlCode;

    public PieceDTO(Piece piece) {
        black = piece.isBlack();
        white = piece.isWhite();
        active = piece.isActive();
        captured = piece.isCaptured();
        position = piece.getPosition();
        htmlCode = piece.getHTMLCode();
    }

    public boolean isBlack() {
        return black;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isCaptured() {
        return captured;
    }

    public A1Notation getPosition() {
        return position;
    }

    public String getHtmlCode() {
        return htmlCode;
    }
}
