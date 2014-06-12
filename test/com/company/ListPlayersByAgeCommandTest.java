package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ListPlayersByAgeCommandTest {

    private ListPlayersByAgeCommand command;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private League league;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        league = mock(League.class);
        command = new ListPlayersByAgeCommand(printStream,bufferedReader, league);
    }

    @Test
    public void shouldDisplayMessageAsOptionInMenu(){
        assertEquals("List all the players older than...", command.name());
    }

//    @Test
//    public void shouldGetListPlayersOlderThanTheSpecificAge() throws Exception {
//        command.listPlayers("26");
//        verify(command).execute();
//    }
}