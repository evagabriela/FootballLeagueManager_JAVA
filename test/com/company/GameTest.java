package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private Game game;
    private Set<Team> teams;
    private Team team;
    private Team team1;

    @Before
    public void setUp(){
       game = new Game();
       teams = new HashSet<Team>();
       team = mock(Team.class);
       team1 = mock(Team.class);
    }

    @Test
    public void shouldAddTeamsToPlayInAGame(){
        teams.add(team);
        game.add(team);

        assertTrue(teams.contains(team));
    }

    @Test
    public void shouldDisplayFinalGameResults(){
        when(team.toString()).thenReturn("team1");
        teams.add(team);
        teams.add(team1);
        game.getTeamsPointsRecordInAGame(team, "3");
        game.getTeamsPointsRecordInAGame(team1, "1");

        assertEquals("Team team1 Score 3 Game Status Won!", game.results(team) );
    }

    @Test
    public void shouldReturnWonGameStatusIfTeamWins(){
        when(team.toString()).thenReturn("team1");
        teams.add(team);
        teams.add(team1);
        game.getTeamsPointsRecordInAGame(team, "3");
        game.getTeamsPointsRecordInAGame(team1, "1");

        assertEquals("Won!", game.getTeamGameStatus(team));
    }

    @Test
    public void shouldReturnLostGameStatusIfTeamLost(){
        when(team.toString()).thenReturn("team1");
        teams.add(team);
        teams.add(team1);
        game.getTeamsPointsRecordInAGame(team, "1");
        game.getTeamsPointsRecordInAGame(team1, "3");

        assertEquals("Lost", game.getTeamGameStatus(team));
    }

}