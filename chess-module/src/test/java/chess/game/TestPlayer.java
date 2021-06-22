package chess.game;

import chess.board.Board;
import chess.board.ClassicBoard;
import chess.move.InvalidMove;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static chess.notations.Position.E2;
import static chess.notations.Position.E4;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestPlayer {

    @Test
    public void when_the_game_starts_e4_plays() {
        Board board = new ClassicBoard();
        assertEquals(board.move(E2, E4), new InvalidMove());
    }
}
