package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class GameTest {
    private Game game;
    private Set<Team> teams;
    private Team team;
    private PrintStream printStream;

    @Before
    public void setUp(){
       game = new Game();
       teams = new HashSet<Team>();
       team = mock(Team.class);
       printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldAddTeamsToPlayInAGame(){
        teams.add(team);
        game.add(team);

        assertTrue(teams.contains(team));
    }

//    How to test random numbers ???

//    @Test
//    public void shouldRecordTheResultOfAGame(){
//        when(team.toString()).thenReturn("team1");
//        Team team2 = new Team(printStream, "team2");
//        game.add(team);
//        game.add(team2);
//        Map<Team, Integer> teamPointsRecord = new HashMap<Team, Integer>();
//        teamPointsRecord.put(team, 1);
//        teamPointsRecord.put(team2, 3);
//        game.getTeamsPointsRecordInAGame();
//
//        assertEquals("Won!", game.getTeamGameStatus(team2));
//    }


//    @Test
//    public void shouldRecordAndDisplayTeamOneRecord(){
//        game.results(team);
//
////        assertEquals("Team: team1 Status:Won! Score:");
//    }


}