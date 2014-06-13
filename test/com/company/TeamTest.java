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

//How to make this two objects equals?
//    @Test
//    public void shouldReturnTheListOfAllTheMembersOfATeam(){
//        when(player.toString()).thenReturn("Name:Gaby Team:"+ team + " Number:3 Age:26");
//        when(coach.toString()).thenReturn("Eva, Head Coach");
//        when(player.isOn("team1")).thenReturn(true);
//        when(coach.isOn("team1")).thenReturn(true);
//        team.addPlayer(player);
//        team.addCoach(coach);
//
//        Team teamTest = new Team(printStream, "team1");
//        Coach coach1 = new Coach("Eva", "Head Coach", teamTest);
//        Player player1 = new Player("Gaby", "3", "26", teamTest);
//        teamTest.addCoach(coach1);
//        teamTest.addPlayer(player1);
//
//
//        assertEquals(teamTest.getListPlayers().iterator().next(), team.team("team1").get(0));
//    }

}