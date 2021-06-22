package chess.notations;

import org.junit.Test;

import static chess.notations.Position.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestPosition {

    @Test
    public void A1_right_is_B1() {
        assertEquals(B1, A1.right());
    }

    @Test
    public void A1_up_is_A2() {
        assertEquals(A2, A1.up());
    }

    @Test
    public void B8_right_is_C8() {
        assertEquals(C8, B8.right());
    }

    @Test
    public void B1_down_is_null() {
        assertNull(B1.down());
    }

    @Test
    public void A1_left_is_null() {
        assertNull(A1.left());
    }
}
