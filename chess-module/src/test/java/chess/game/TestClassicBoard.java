package chess.game;

import chess.board.Board;
import chess.board.ClassicBoard;
import chess.board.FreeBoard;
import chess.piece.black.BlackQueen;
import chess.piece.white.WhiteQueen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chess.notations.Position.*;
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
    public void promote_to_queen() {
        Board board = new ClassicBoard();
        board.move(A2, A4);
        board.move(C7, C6);

        board.move(A4, A5);
        board.move(C6, C5);

        board.move(A5, A6);
        board.move(C5, C4);

        board.move(A6, B7);
        board.move(C4, C3);

        board.move(B7, C8);
        assertTrue(board.getPieceAt(C8) instanceof WhiteQueen);
    }

    @Test
    public void promote_to_queen_2() {
        Board board = new ClassicBoard();
        board.move(E2, E4);
        board.move(D7, D5);
        board.move(E4, E5);
        board.move(C7, C5);
        board.move(D2, D4);
        board.move(C5, D4);
        board.move(C2, C3);
        board.move(D4, D3);
        board.move(C3, C4);
        board.move(D3, D2);
        board.move(E1, E2);
        board.move(D2, C1);
        assertTrue(board.getPieceAt(C1) instanceof BlackQueen);
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
    public void when_D4_E5_then_pawn_can_capture_on_E5() {
        Board board = new ClassicBoard();
        assertNotNull(board.move(D2, D4));
        assertNotNull(board.move(E7, E5));
        assertNotNull(board.move(D4, E5));
        assertTrue(board.isOccupiedByWhitePiece(E5));
        assertTrue(board.isEmpty(D4));
    }

    @Test
    public void test_cannot_move_king_next_to_the_other_king() {
        Board board = new FreeBoard();
        board.putWhiteKing(C5);
        board.putBlackKing(E5);

        assertNull(board.move(C5, D5));

        assertEquals(C5, board.getWhitesKingPosition());
        assertEquals(E5, board.getBlacksKingPosition());
    }

    @Test
    public void test_knights_positions() {
        Board board = new ClassicBoard();

        assertEquals(Stream.of(A3, C3).collect(Collectors.toSet()),
                board.getPieceAt(B1).getAllPossibleMoves());
    }

    @Test
    public void test_bishop_positions() {
        Board board = new ClassicBoard();
        board.move(D2, D3);
        board.move(D7, D6);
        board.move(B2, B3);

        assertEquals(Stream.of(D2, E3, H6, F4, G5, B2, A3).collect(Collectors.toSet()),
                board.getPieceAt(C1).getAllPossibleMoves());
    }

    @Test
    public void test_bishop_positions_1() {
        Board board = new ClassicBoard();
        board.move(D2, D3);
        board.move(D7, D6);

        assertEquals(Stream.of(D2, E3, H6, F4, G5).collect(Collectors.toSet()),
                board.getPieceAt(C1).getAllPossibleMoves());
    }

    @Test
    public void test_bishop_positions_2() {
        Board board = new ClassicBoard();
        board.move(D2, D3);
        board.move(D7, D6);
        board.move(C1, G5);

        assertEquals(Stream.of(C1, E3, H4, D2, H6, E7, F4, F6).collect(Collectors.toSet()),
                board.getPieceAt(G5).getAllPossibleMoves());
    }

    @Test
    public void test_bishop_positions_3() {
        Board board = new ClassicBoard();
        board.move(D2, D3);
        board.move(D7, D6);
        board.move(C1, G5);
        board.move(F7, F6);

        assertEquals(Stream.of(C1, E3, H4, D2, H6, F4, F6).collect(Collectors.toSet()),
                board.getPieceAt(G5).getAllPossibleMoves());
    }

}

