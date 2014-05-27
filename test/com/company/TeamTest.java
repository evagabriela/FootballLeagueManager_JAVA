package com.company;


import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TeamTest {
    @Test
    public void shouldPrintPlayersOnATeam(){
       PrintStream printStream = mock(PrintStream.class);
       List<Player> players = new ArrayList<Player>();
        Player[] arrayPlayers = {new Player("Gaby")};
        players.addAll(asList(arrayPlayers));

       Team team = new Team( printStream, players);
       team.listPlayers();
       verify(printStream).println(players.get(0));
    }

}