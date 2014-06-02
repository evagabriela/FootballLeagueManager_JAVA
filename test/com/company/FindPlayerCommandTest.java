package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FindPlayerCommandTest {
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private Team team;
    private FindPlayerCommand command;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        team = mock(Team.class);
        command = new FindPlayerCommand(printStream, bufferReader, team);

    }

    @Test
    public void shouldDisplayMessageInAMenuOption(){
        assertEquals("Find a player by name and number", command.name());
    }

    @Test
    public void shouldPromptToEnterNameOfPlayer(){
        command.execute();
        verify(printStream).println("Enter the name of the player");
    }

    @Test
    public void shouldPromptToEnterNumberOfPlayer() throws IOException {
        when(bufferReader.readLine()).thenReturn("Gaby");
        command.execute();
        verify(printStream).println("Enter the number of the player");
    }

    @Test
    public void shouldPrintMessageIfInvalidEntry() throws IOException {
        when(bufferReader.readLine()).thenReturn("Joseph").thenReturn("10");
        command.execute();
        verify(printStream).println("Sorry but we couldn't find a player with the information that your provided");
    }

    @Test
    public void shouldPrintMessageIfInvalidNameEntry() throws IOException {
        when(bufferReader.readLine()).thenReturn("Marylin");
        command.execute();
        verify(printStream).println("Sorry but we couldn't find a player with the information that your provided");
    }

    @Test
    public void shouldPrintMessageIfInvalidPlayerNumberEntry() throws IOException {
        when(bufferReader.readLine()).thenReturn("Gaby").thenReturn("1");
        command.execute();
        verify(printStream).println("Sorry but we couldn't find a player with the information that your provided");
    }

}