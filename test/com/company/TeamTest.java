package com.company;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TeamTest {

    private Player player;
    private PrintStream printStream;
    private Team team;
    private  List<Player> players;
    private Set<Coaches> coaches;
    private Coaches coach;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        coach = mock(Coaches.class);
        coaches = new HashSet<Coaches>();
        coaches.add(coach);
        players = asList(player);
        team = new Team(printStream, players, coaches);
    }

    @Test
    public void shouldPrintPlayersOnATeam(){
       when(player.toString()).thenReturn("Name:Gaby Team:Ohio Number:3 Age:26");
       List<Player> players = asList(player);
       Team team = new Team(printStream, players, coaches);
       team.listPlayers();

       verify(printStream).println("Name:Gaby Team:Ohio Number:3 Age:26");
    }

    @Test
    public void shouldReturnPlayerInformationIfSearchedByNameAndNumber(){
        when(player.toString()).thenReturn("Name:Gaby Team:Ohio Number:3 Age:26");
        when(player.hasName("Gaby")).thenReturn(true);
        when(player.hasNumber("3")).thenReturn(true);
        List<Player> players = asList(player);
        Team team = new Team(printStream, players, coaches);

        Player player = team.findPlayer("Gaby", "3");
        assertEquals("Name:Gaby Team:Ohio Number:3 Age:26", player.toString());
    }

    @Test
    public void shouldReturnPlayerAndCoachesInformationWhenOptionOne(){
        when(coach.toString()).thenReturn("Eva Atunga Ohio Head Coach");
        coaches.add(coach);
        Team team = new Team(printStream, players, coaches);
        team.listCoaches();
        verify(printStream).println("Eva Atunga Ohio Head Coach");
    }

    //pending to add the logic on how am I going to add players to a new team
//        Ideas:
//        -have another class which knows about all the teams (ex, league class knows about all the teams in the league of soccer)
}