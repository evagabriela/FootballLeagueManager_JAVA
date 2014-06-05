package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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


//    @Test
//    public void shouldListPlayersInALeague() throws Exception {
//        when(team.toString()).thenReturn("team1");
//        when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
////        Set<Player> leaguePlayers = new HashSet<Player>();
////        leaguePlayers.add(player);
//        team.addPlayer(player);
//        league.addTeam(team);
//
//
//        assertTrue(league.getListPlayers().contains(player));
//    }



//    @Test
//    public void shouldFindAPlayerInALeague() throws Exception {
//        when(team.toString()).thenReturn("team1");
//        when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
//        when(player.hasNameAndNumber("Gaby", "3")).thenReturn(true);
//
//
//        assertEquals(player, league.findPlayer(player.toString(), team.toString()));
//    }

    @Test
    public void ShouldBeAbleToFindATeam() throws Exception {
        when(team.toString()).thenReturn("team1");
        teams.add(team);
        league.addTeam(team);
        when(team.hasName("team1")).thenReturn(true);

        assertEquals(team,league.findTeam("team1") );
    }

//    @Test
//    public void ShouldTradeAPlayerFromTeamToOtherTeam() throws Exception {
//        Team team1 = new Team(printStream, "team1");
//        Team team2 = new Team(printStream, "team2");
//        when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
//
//        team1.addPlayer(player);
//        player.setTeam(team1);
//
//        league.tradePlayer(player, team2);
//
//        verify(player).setTeam(team2);
//    }

//    **** From the old Team tests ****


//    public void shouldReturnCorrectPlayerWhenSearchedByNameAndNumber(){


//    @Test
//    public void shouldReturnCoachesWhenListCoaches(){
//        when(coach.toString()).thenReturn("Eva Atunga Ohio Head Coach");
//        coaches.add(coach);
//        Team team = new Team(printStream, "team1");
//        team.listCoaches();
//        verify(printStream).println("Eva Atunga Ohio Head Coach");
//    }


//    @Test
//    public void shouldReturnInvalidMessageIfPlayerNameIsIncorrect(){
//        Player player1 = mock(Player.class);
//        when(player1.toString()).thenReturn("Katy Michigan 1 25");
//
//        Player player2 = mock(Player.class);
//        when(player2.toString()).thenReturn("Peter California 2 23");
//
//        List<Player> players = asList(player1, player2);
//
//        League league = new League(printStream, players, coaches);
//
//        findPlayerCommand.execute();
//        league.findPlayer("Katy", "3");
//
//
//        verify(printStream).println("Sorry but we couldn't find a player with the information that your provided");


}