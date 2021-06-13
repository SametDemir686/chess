package chess.match;

import chess.piece.PieceDTO;

import static chess.match.Perspective.BLACK;
import static chess.match.Perspective.WHITE;

public class Match {
    private MatchBoard matchBoard = new MatchBoard();

    public Match() {
        matchBoard.initializeBoard();
    }

    public boolean move(A1Notation from, A1Notation to) {
        return matchBoard.move(from, to);
    }

    public PieceDTO[][] getBoard(Perspective perspective) {
        if (perspective == WHITE) return matchBoard.getBoardByWhitePerspective();
        if (perspective == BLACK) return matchBoard.getBoardByBlackPerspective();
        throw new IllegalStateException("Unexpected value: " + perspective);
    }

    public String getBoardAsString(Perspective perspective) {
        if (perspective == WHITE) return matchBoard.getBoardAsStringByWhitePerspective();
        if (perspective == BLACK) return matchBoard.getBoardAsStringByBlackPerspective();
        throw new IllegalStateException("Unexpected value: " + perspective);
    }
}
