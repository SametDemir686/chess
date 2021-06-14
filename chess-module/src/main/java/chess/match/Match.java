package chess.match;

import chess.piece.PieceDTO;

import static chess.match.Perspective.BLACK;
import static chess.match.Perspective.WHITE;

public class Match {
    private Board board = new MatchBoard();

    public Match() {
        board.initializeBoard();
    }

    public boolean move(A1Notation from, A1Notation to) {
        return board.move(from, to);
    }

    public PieceDTO[][] getBoard(Perspective perspective) {
        if (perspective == WHITE) return board.getBoardByWhitePerspective();
        if (perspective == BLACK) return board.getBoardByBlackPerspective();
        throw new IllegalStateException("Unexpected value: " + perspective);
    }

    public String getBoardAsString(Perspective perspective) {
        if (perspective == WHITE) return board.getBoardAsStringByWhitePerspective();
        if (perspective == BLACK) return board.getBoardAsStringByBlackPerspective();
        throw new IllegalStateException("Unexpected value: " + perspective);
    }

    public void restart() {
        board.resetBoard();
    }
}
