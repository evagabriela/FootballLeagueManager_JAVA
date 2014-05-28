package com.company;


import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TeamTest {
    @Test
    public void shouldPrintPlayersOnATeam(){
       PrintStream printStream = mock(PrintStream.class);
        Player player = mock(Player.class);
        when(player.toString()).thenReturn("Name:Gaby Team:Ohio Number:3 Age:26");

        List<Player> players = asList(player);

       Team team = new Team(printStream, players);
       team.listPlayers();
       verify(printStream).println(player);

    }

}