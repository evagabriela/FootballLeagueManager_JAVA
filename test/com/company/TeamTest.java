package com.company;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;


public class TeamTest {

    private Player player;
    private PrintStream printStream;
    private Team team;
    private Set<Coach> coaches;
    private Coach coach;
    private Set<Player> playersSet;
    private League league;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        coach = mock(Coach.class);
        coaches = new HashSet<Coach>();
        coaches.add(coach);
        playersSet = new HashSet<Player>();
        playersSet.add(player);
        team = new Team(printStream, "team1");
        league = mock(League.class);

    }

    @Test
    public void shouldPrintNameOfTeam(){
        assertEquals("team1", team.toString());
    }

    @Test
    public void shouldReturnAListOfPlayersOfATeam(){
        when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
        team.addPlayer(player);

        assertTrue(team.getListPlayers().contains(player));
    }

    @Test
    public void shouldReturnTheCoachesInATeam(){
        when(coach.toString()).thenReturn("Eva Atunga");
        team.addCoach(coach);

        assertTrue(team.getListCoaches().contains(coach));
    }

    @Test
    public void shouldPrintTheNameOfTheCoaches(){
        when(coach.toString()).thenReturn("Eva Atunga");
        team.addCoach(coach);
        team.listCoaches();
        verify(printStream).println("Eva Atunga");

    }

    @Test
    public void shouldReturnTrueIfTeamNameIsEqualsToInput(){
        assertTrue(team.hasName("team1"));
    }

//  Do I Need to write the following tests?  we are just testing that we can add to a hashset
    @Test
    public void shouldAddPlayerInATeam(){
        team.addPlayer(player);
        assertTrue(playersSet.contains(player));
    }

    @Test
    public void shouldRemovePlayerInATeam(){
        playersSet.remove(player);
        team.removePlayer(player);
        assertFalse(playersSet.contains(player));
    }

    @Test
    public void shouldAddCoachInATeam(){
        team.addCoach(coach);
        assertTrue(coaches.contains(coach));
    }

//    ***** Need to finish this one? why doesnt work?

//    @Test
//    public void shouldReturnTheListOfAllTheMembersOfATeam(){
////        when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
////        when(coach.toString()).thenReturn("Eva Atunga");
//        when(player.isOn("team1")).thenReturn(true);
//        when(coach.isOn("team1")).thenReturn(true);
//
//        team.addPlayer(player);
//        team.addCoach(coach);
////        playersSet.add(player);
//
//        coaches.add(coach);
//        league.addTeam(team);
//
//        assertEquals("bla", team.team("Team1"));
//    }

}