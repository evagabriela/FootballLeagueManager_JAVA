package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TradePlayerCommandTest {
    private TradePlayerCommand command;
    private League league;
    private PrintStream printStream;
    private BufferedReader bufferReader;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        league = mock(League.class);
        command = new TradePlayerCommand(printStream, bufferReader, league);
    }

    @Test
    public void shouldDisplayAMessageInMenuOption(){
        assertEquals("Trade Player", command.name());
    }

    @Test
    public void shouldPromptToEnterNameOfPlayer(){
        command.execute();
        verify(printStream).println("Enter the name of the player: ");
    }

    @Test
    public void shouldPromptToEnterNumberOfPlayer() throws IOException {
        when(bufferReader.readLine()).thenReturn("Gaby");
        command.execute();
        verify(printStream).println("Enter the number of the player: ");
    }


}