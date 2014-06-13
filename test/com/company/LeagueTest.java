package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeagueTest {

    private Team team;
    private Set<Team> teams;
    private League league;
    private Player player;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
       league = new League();
        team = mock(Team.class);
        teams = new HashSet<Team>();
        player = mock(Player.class);
        printStream = mock(PrintStream.class);

    }

    @Test
    public void shouldAddTeamToTheLeague() throws Exception {
        when(team.toString()).thenReturn("team1");
        teams.add(team);
        league.addTeam(team);

        assertTrue(teams.contains(team));
    }

    @Test
    public void shouldListTeamsInALeague(){
        league.addTeam(team);

        assertTrue(league.getListTeams().contains(team));
    }

    @Test
    public void shouldGetTeamListOfPlayersFromATeam(){
        league.addTeam(team);

        league.getListPlayers();

        verify(team).getListPlayers();
    }

    @Test
    public void shouldFindTeamOnALeague(){
        when(team.toString()).thenReturn("team1");
        when(team.hasName("team1")).thenReturn(true);

        league.addTeam(team);

        assertEquals(team,league.findTeam("team1") );
    }


}