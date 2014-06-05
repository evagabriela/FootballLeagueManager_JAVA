package com.company;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class TeamTest {

    private Player player;
    private PrintStream printStream;
    private Team team;
    private  List<Player> players;
    private Set<Coach> coaches;
    private Coach coach;
    private FindPlayerCommand findPlayerCommand;
    private Set<Player> playersSet;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        coach = mock(Coach.class);
        coaches = new HashSet<Coach>();
        coaches.add(coach);
        players = asList(player);
        playersSet = new HashSet<Player>();
        team = new Team(printStream, "team1");
        findPlayerCommand = mock(FindPlayerCommand.class);
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

//    @Test
//    public void shouldAddAPlayerIntoTheTeam(){
//         when(team.toString()).thenReturn("team1");
//         when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
//
//         team.addPlayer(player);
//
//         assertEquals(player, team.getListPlayers().iterator().next());
//
//    }

//    @Test
//    public void shouldRemoveAPlayerFromATeam(){
//         when(team.toString()).thenReturn("team1");
//         when(player.toString()).thenReturn("Name:Gaby Team:"+team + " Number: 3 Age: 26");
//         team.removePlayer(player);
//
//        assertFalse(playersSet.contains(player));
//    }





}