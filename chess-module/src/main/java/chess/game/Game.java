package chess.game;

import chess.match.Match;

public class Game {
    private int noOfMatchesToPlay;
    private Match[] matches;

    public Game(int noOfMatchesToPlay) {
        this.noOfMatchesToPlay = noOfMatchesToPlay;
        this.matches = new Match[noOfMatchesToPlay];
    }
}
