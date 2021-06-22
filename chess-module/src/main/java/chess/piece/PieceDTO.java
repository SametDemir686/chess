package chess.piece;

import chess.notations.Position;

public class PieceDTO {

    private boolean black;
    private boolean white;
    private boolean active;
    private boolean captured;
    private Position position;
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

    public Position getPosition() {
        return position;
    }

    public String getHtmlCode() {
        return htmlCode;
    }
}
