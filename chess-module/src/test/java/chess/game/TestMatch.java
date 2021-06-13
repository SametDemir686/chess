package chess.game;

import chess.match.Match;
import chess.match.Perspective;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static chess.match.A1Notation.*;

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

        System.out.println(match.getBoardAsString(Perspective.WHITE));
    }

}

