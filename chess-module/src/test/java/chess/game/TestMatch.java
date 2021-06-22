package chess.game;

import chess.match.Match;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static chess.notations.Position.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMatch {

    @Test
    public void test() {
        Match match = new Match();
        match.move(A2, A4);
        match.move(D7, D5);
        match.move(E2, E4);
        match.move(E7, E5);
        match.move(E4, D5);

    }

}

