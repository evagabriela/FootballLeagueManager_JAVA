package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    private Player player;
    private League league;
    private Team team1;
    private PrintStream printStream;

    @Before
    public void setUp(){

        league = mock(League.class);
        team1 = mock(Team.class);
        player = new Player("Gaby", "3", "26", team1);
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldDisplayFullPlayerInformationAsString(){
        assertEquals("Name:Gaby Team:" + team1+  " Number:3 Age:26", player.toString());
    }

    @Test
    public void shouldReturnTrueIfPlayerNameAndNumberMatchesTheOneInTheTeam(){
        team1.addPlayer(player);
        league.addTeam(team1);

        assertTrue(player.hasNameAndNumber("Gaby", "3"));
    }

    @Test
    public void shouldReturnFalseIfPlayerNameDoesntMatchTheOneInTheTeam(){
        team1.addPlayer(player);
        league.addTeam(team1);

        assertFalse(player.hasNameAndNumber("Maria", "3"));
    }

    @Test
    public void shouldBeAbleToSetAPlayerInATeam(){
        Team team2 = new Team(printStream, "team2");
        team2.addPlayer(player);
        player.setTeam(team2);

        assertTrue(team2.getListPlayers().contains(player));
    }

}