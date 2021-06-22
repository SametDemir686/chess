package chess.notations;


import chess.piece.white.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static chess.notations.Position.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestWhitesMove {

    @Test
    public void e4_means_pawn_to_e5() {
        WhitesMove whitesMove = new WhitesMove("e4");

        assertFalse(whitesMove.isCapture());
        assertEquals(E4, whitesMove.to());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhitePawn);
    }

    @Test
    public void d5_means_pawn_to_d5() {
        WhitesMove whitesMove = new WhitesMove("d5");

        assertEquals(D5, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhitePawn);
    }

    @Test
    public void Nd3_means_knight_to_e3() {
        WhitesMove whitesMove = new WhitesMove("Nd3");

        assertEquals(D3, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteKnight);
    }

    @Test
    public void Qe5_means_queen_to_e5() {
        WhitesMove whitesMove = new WhitesMove("Qe5");

        assertEquals(E5, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteQueen);
    }

    @Test
    public void Bc1_means_bishop_to_c1() {
        WhitesMove whitesMove = new WhitesMove("Bc1");

        assertEquals(C1, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteBishop);
    }

    @Test
    public void Kc1_means_king_to_c1() {
        WhitesMove whitesMove = new WhitesMove("Kc1");

        assertEquals(C1, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteKing);
    }

    @Test
    public void Rc1_means_rook_to_c1() {
        WhitesMove whitesMove = new WhitesMove("Rc1");

        assertEquals(C1, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteRook);
    }

    @Test
    public void Bxe5_means_bishop_captures_on_e5() {
        WhitesMove whitesMove = new WhitesMove("Bxe5");

        assertEquals(E5, whitesMove.to());
        assertTrue(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteBishop);
    }

    @Test
    public void Qxe2_means_bishop_captures_on_e2() {
        WhitesMove whitesMove = new WhitesMove("Qxe2");

        assertEquals(E2, whitesMove.to());
        assertTrue(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteQueen);
    }

    @Test
    public void dxe5_means_d_pawn_captures_on_e5() {
        WhitesMove whitesMove = new WhitesMove("dxe5");

        assertEquals(E5, whitesMove.to());
        assertTrue(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhitePawn);
    }

    @Test
    public void O_O_means_short_castling() {
        WhitesMove whitesMove = new WhitesMove("O-O");

        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.isShortCastling());
        assertFalse(whitesMove.isLongCastling());
    }

    @Test
    public void O_O_O_means_short_castling() {
        WhitesMove whitesMove = new WhitesMove("O-O-O");

        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.isLongCastling());
        assertFalse(whitesMove.isShortCastling());
    }

    @Test
    public void R1e7_means_rook_at_horizon_1_moves_to_e7() {
        WhitesMove whitesMove = new WhitesMove("R1e7");

        assertEquals(E7, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertEquals("1", whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteRook);
    }

    @Test
    public void Rde7_means_rook_at_vertice_d_moves_to_e7() {
        WhitesMove whitesMove = new WhitesMove("Rde7");

        assertEquals(E7, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertEquals("d", whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteRook);
    }

    @Test
    public void Rd7e7_means_rook_at_d7_moves_to_e7() {
        WhitesMove whitesMove = new WhitesMove("Rd7e7");

        assertEquals(E7, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertEquals("d7", whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteRook);
    }

    @Test
    public void Rd7xe7_means_rook_at_d7_captures_at_e7() {
        WhitesMove whitesMove = new WhitesMove("Rd7xe7");

        assertEquals(E7, whitesMove.to());
        assertTrue(whitesMove.isCapture());
        assertEquals("d7", whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhiteRook);
    }

    @Test
    public void e8_Q_means_e_pawn_promotes_to_a_queen() {
        WhitesMove whitesMove = new WhitesMove("e8=Q");

        assertEquals(E8, whitesMove.to());
        assertFalse(whitesMove.isCapture());
        assertNull(whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhitePawn);
    }

    @Test
    public void cxd8_Q_means_c_pawn_capture_at_d8_and_promotes_to_a_queen() {
        WhitesMove whitesMove = new WhitesMove("cxd8=Q");

        assertEquals(D8, whitesMove.to());
        assertTrue(whitesMove.isCapture());
        assertEquals("c", whitesMove.distinguisher());
        assertTrue(whitesMove.piece() instanceof WhitePawn);
    }

}