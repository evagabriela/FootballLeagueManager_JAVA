package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListGameResultsCommandTest {
    private Game game;
    private ListGameResultsCommand command;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Team team;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        game = mock(Game.class);
        bufferedReader = mock(BufferedReader.class);
        command = new ListGameResultsCommand(printStream,bufferedReader, game);
        team = mock(Team.class);
    }

    @Test
    public void shouldDisplayMessageInAMenuOption(){
        assertEquals("List the results of a Game", command.name());
    }

    @Test
    public void shouldDisplayTheGameResultsForAParticularTeam() throws IOException {
        when(bufferedReader.readLine()).thenReturn("team1");
        when(game.getTeam("team1")).thenReturn(team);

        command.execute();

        verify(game).results(team);
    }

}