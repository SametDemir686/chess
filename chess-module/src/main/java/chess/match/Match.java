package chess.match;

import chess.board.Board;
import chess.board.ClassicBoard;
import chess.piece.PieceDTO;

import static chess.match.Perspective.BLACK;
import static chess.match.Perspective.WHITE;
import static chess.util.MatrixUtil.*;

public class Match {
    private Board board = new ClassicBoard();

    public boolean move(A1Notation from, A1Notation to) {
        return board.move(from, to);
    }

    public PieceDTO[][] getBoard(Perspective perspective) {
        if (perspective == WHITE) return getBoardByWhitePerspective();
        if (perspective == BLACK) return getBoardByBlackPerspective();
        throw new IllegalStateException("Unexpected value: " + perspective);
    }

    public void restart() {
        board.resetBoard();
    }

    public PieceDTO[][] getBoardByWhitePerspective() {
        PieceDTO[][] result = board.getBoardDTO();
        transpose(result);
        rotateLeft(result);
        return result;
    }

    public String boardToString() {
        return this.board.toString();
    }

    public PieceDTO[][] getBoardByBlackPerspective() {
        PieceDTO[][] result = board.getBoardDTO();
        transpose(result);
        rotateRight(result);
        return result;
    }
}
