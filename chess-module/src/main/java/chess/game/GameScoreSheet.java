package chess.game;

import static chess.game.GameResult.*;

public class GameScoreSheet {
    private double player1Score = 0;
    private double player2Score = 0;

    private int noOfMatchesToPlay;

    public GameScoreSheet(int noOfMatchesToPlay) {
        this.noOfMatchesToPlay = noOfMatchesToPlay;
    }

    public double getPlayer1Score() {
        return player1Score;
    }

    public double getPlayer2Score() {
        return player2Score;
    }

    public void player1WinsMatch() {
        player1Score++;
    }

    public void player2WinsMatch() {
        player2Score++;
    }

    public boolean isOver() {
        double noOfMatchesPlayed = player1Score + player2Score;
        return noOfMatchesPlayed == noOfMatchesToPlay
                || getNoOfMatchesToWin() == player2Score
                || getNoOfMatchesToWin() == player1Score;
    }

    public void drawMatch() {
        player1Score = player1Score + 0.5;
        player2Score = player2Score + 0.5;
    }

    public double getNoOfMatchesToWin() {
        return noOfMatchesToPlay / 2.0 + 0.5;
    }

    public GameResult getWinner() {
        if (!isOver()) return NOT_OVER_YET;
        if (player1Score == player2Score) return DRAW;
        if (player1Score > player2Score) return PLAYER_1_WINS;
        return PLAYER_2_WINS;
    }

}
