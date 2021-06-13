package chess.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestGame {

    @Test
    public void initilize_game_with_10_matches() {
        Game game = new Game(10);
    }

    @Test
    public void initilize_game_with_5_matches() {
        Game game = new Game(5);
    }

}

