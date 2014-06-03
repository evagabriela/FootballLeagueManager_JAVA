package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TradePlayerCommandTest {
    private TradePlayerCommand command;
    private Team team;
    private PrintStream printStream;
    private BufferedReader bufferReader;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        team = mock(Team.class);
        command = new TradePlayerCommand(printStream, bufferReader, team);
    }

    @Test
    public void shouldDisplayAMessageInMenuOption(){
        assertEquals("Trade Player", command.name());
    }


}