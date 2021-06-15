package chess.game;

import chess.board.Board;
import chess.board.ClassicBoard;
import chess.board.FreeBoard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static chess.match.A1Notation.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestClassicBoard {

    @Test
    public void fools_mate() {
        Board board = new ClassicBoard();
        board.move(F2, F3);
        board.move(E7, E6);
        board.move(G2, G4);
        board.move(D8, H4);
        assertTrue(board.isCheckMate());
    }

    @Test
    public void stale_mate() {
        Board board = new FreeBoard();
        board.putWhiteKing(A1);
        board.putBlackKing(A3);
        board.putBlackBishop(B1);
        board.putBlackKnight(D2);
        assertTrue(board.isStaleMate());
    }

    @Test
    public void stale_mate_2() {
        Board board = new FreeBoard();
        board.putWhiteKing(A1);
        board.putBlackKing(A3);
        board.putBlackRook(B2);
        assertTrue(board.isStaleMate());
    }

    @Test
    public void when_the_game_starts_it_is_not_stale_mate() {
        Board board = new ClassicBoard();
        assertFalse(board.isStaleMate());
    }

    @Test
    public void when_the_game_starts_it_is_not_check_mate() {
        Board board = new ClassicBoard();
        assertFalse(board.isCheckMate());
    }

    @Test
    public void when_D4_D5_then_pawn_can_capture_on_D5() {
        Board board = new ClassicBoard();
        assertTrue(board.move(D2, D4));
        assertTrue(board.move(D7, D5));
        assertTrue(board.move(D4, D5));
        assertTrue(board.isOccupiedByWhitePiece(D5));
        assertTrue(board.isEmpty(D4));
    }

    @Test
    public void test_cannot_move_king_next_to_the_other_king() {
        Board board = new FreeBoard();
        board.putWhiteKing(C5);
        board.putBlackKing(E5);

        assertFalse(board.move(C5, D5));

        assertEquals(C5, board.getWhitesKingPosition());
        assertEquals(E5, board.getBlacksKingPosition());
    }

}

