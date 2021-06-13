package chess.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestGameScoreSheet {

    @Test
    public void when_game_starts_player_1_score_is_0() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        assertEquals(0, gameScoreSheet.getPlayer1Score(), 0.01);
    }

    @Test
    public void when_game_starts_player_2_score_is_0() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        assertEquals(0, gameScoreSheet.getPlayer2Score(), 0.01);
    }

    @Test
    public void when_game_starts_and_player_1_wins_a_match_then_score_is_1_0() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        gameScoreSheet.player1WinsMatch();
        assertEquals(1, gameScoreSheet.getPlayer1Score(), 0.01);
        assertEquals(0, gameScoreSheet.getPlayer2Score(), 0.01);
    }

    @Test
    public void when_game_starts_and_player_2_wins_a_match_then_score_is_0_1() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        gameScoreSheet.player2WinsMatch();
        assertEquals(0, gameScoreSheet.getPlayer1Score(), 0.01);
        assertEquals(1, gameScoreSheet.getPlayer2Score(), 0.01);
    }

    @Test
    public void when_player_2_wins_5_matches_then_game_is_over() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(9);
        gameScoreSheet.player2WinsMatch();
        gameScoreSheet.player2WinsMatch();
        gameScoreSheet.player2WinsMatch();
        gameScoreSheet.player2WinsMatch();
        gameScoreSheet.player2WinsMatch();
        assertTrue(gameScoreSheet.isOver());
    }

    @Test
    public void when_player_1_wins_5_matches_then_game_is_over() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(9);
        gameScoreSheet.player1WinsMatch();
        gameScoreSheet.player1WinsMatch();
        gameScoreSheet.player1WinsMatch();
        gameScoreSheet.player1WinsMatch();
        gameScoreSheet.player1WinsMatch();
        assertTrue(gameScoreSheet.isOver());
    }

    @Test
    public void when_game_starts_then_game_is_not_over() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        assertFalse(gameScoreSheet.isOver());
    }

    @Test
    public void when_game_is_draw_then_half_points_for_each_player() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        gameScoreSheet.drawMatch();
        assertEquals(0.5, gameScoreSheet.getPlayer1Score(), 0.01);
        assertEquals(0.5, gameScoreSheet.getPlayer2Score(), 0.01);
    }

    @Test
    public void when_ten_draws_then_game_is_over() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(10);
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        assertTrue(gameScoreSheet.isOver());
    }

    @Test
    public void when_number_of_matches_is_4_then_4_draws_will_end_the_game() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(4);
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        gameScoreSheet.drawMatch();
        assertTrue(gameScoreSheet.isOver());
    }

    @Test
    public void when_no_of_matches_to_play_is_1_and_player_1_wins_the_match_then_player_1_wins_the_game() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(1);
        gameScoreSheet.player1WinsMatch();
        assertEquals(GameResult.PLAYER_1_WINS, gameScoreSheet.getWinner());
    }

    @Test
    public void when_no_of_matches_to_play_is_1_and_player_2_wins_the_match_then_player_2_wins_the_game() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(1);
        gameScoreSheet.player2WinsMatch();
        assertEquals(GameResult.PLAYER_2_WINS, gameScoreSheet.getWinner());
    }

    @Test
    public void when_no_of_matches_to_play_is_1_and_the_match_is_drawn_then_the_game_is_drawn() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(1);
        gameScoreSheet.drawMatch();
        assertEquals(GameResult.DRAW, gameScoreSheet.getWinner());
    }

    @Test
    public void when_game_starts_then_game_is_not_over_yet() {
        GameScoreSheet gameScoreSheet = new GameScoreSheet(1);
        assertEquals(GameResult.NOT_OVER_YET, gameScoreSheet.getWinner());
    }

}

