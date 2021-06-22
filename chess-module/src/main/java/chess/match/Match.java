package chess.match;

import chess.board.Board;
import chess.board.ClassicBoard;
import chess.notations.Perspective;
import chess.notations.Position;
import chess.piece.Piece;
import chess.piece.PieceDTO;

import static chess.board.AbstractClassicBoard.BOARD_SIZE;

public class Match {
    private Board board = new ClassicBoard();

    public boolean move(Position from, Position to) {
        return board.move(from, to) != null;
    }

    public PieceDTO[][] getBoard(Perspective perspective) {
        return getBoardDTO(perspective);
    }

    public void restart() {
        board.resetBoard();
    }

    public String boardToString() {
        return this.board.toString();
    }

    public PieceDTO[][] getBoardDTO(Perspective perspective) {
        PieceDTO[][] result = new PieceDTO[BOARD_SIZE][BOARD_SIZE];
        Piece[][] pieces = this.board.getBoard(perspective);
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                result[i][j] = new PieceDTO(pieces[i][j]);
            }
        }
        return result;
    }

}
