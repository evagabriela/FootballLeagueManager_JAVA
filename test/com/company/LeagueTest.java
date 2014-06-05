package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LeagueTest {

    private Team team;
    private HashSet<Team> teams;
    private League league;
    private HashSet<Player> players;
    private Player player;

    @Before
    public void setUp() throws Exception {
       league = new League();
        teams = new HashSet<Team>();
        team = mock(Team.class);
        teams.add(team);
        player = mock(Player.class);
       ;

    }

    @Test
    public void shouldAddTeamToTheLeague() throws Exception {
        when(team.toString()).thenReturn("team1");
        league.addTeam(team);
        assertTrue(teams.contains(team));
    }

    @Test
    public void shouldBeAbleToGetAListOfAllTeamsInALeague() throws Exception {
        when(team.toString()).thenReturn("team1");
        league.addTeam(team);
        assertTrue(league.getListTeams().contains(team));
    }

    @Test
    public void shouldBeAbleToGetAListOfAllPlayers() throws Exception {
        league.getListPlayers();
    }

    @Test
    public void shouldBeAbleToFindAPlayer() throws Exception {
        league.findPlayer(player.toString(), team.toString());
    }

    @Test
    public void ShouldBeAbleToFindATeam() throws Exception {

    }

    @Test
    public void ShouldBeAbleToTradeAPlayer() throws Exception {

    }
}