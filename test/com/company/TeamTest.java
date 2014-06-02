package com.company;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TeamTest {

    private Player player;
    private PrintStream printStream;
    private Team team;
    private  List<Player> players;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        players = asList(player);
        team = new Team(printStream, players);
    }

    @Test
    public void shouldPrintPlayersOnATeam(){
       when(player.toString()).thenReturn("Name:Gaby Team:Ohio Number:3 Age:26");
       List<Player> players = asList(player);
       Team team = new Team(printStream, players);
       team.listPlayers();

       verify(printStream).println("Name:Gaby Team:Ohio Number:3 Age:26");
    }

    @Test
    public void shouldReturnPlayerInformationIfSearchedByNameAndNumber(){
        when(player.toString()).thenReturn("Name:Gaby Team:Ohio Number:3 Age:26");
        when(player.hasName("Gaby")).thenReturn(true);
        when(player.hasNumber("3")).thenReturn(true);
        List<Player> players = asList(player);
        Team team = new Team(printStream, players);

        Player player = team.findPlayer("Gaby", "3");
        assertEquals("Name:Gaby Team:Ohio Number:3 Age:26", player.toString());
    }
}