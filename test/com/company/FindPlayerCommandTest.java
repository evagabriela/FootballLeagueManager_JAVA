package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FindPlayerCommandTest {
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private League league;
    private FindPlayerCommand command;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        league = mock(League.class);
        command = new FindPlayerCommand(printStream, bufferReader, league);

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
        command.execute();
        verify(printStream).println("Enter the number of the player");
    }

    @Test
    public void shouldReturnAnInvalidMessageIfPlayerInformationIsIncorrectOrNull(){
        when(league.findPlayer("Gaby", "1")).thenReturn(null);
        command.execute();

        verify(printStream).println("Sorry but we couldn't find a player with the information that your provided");
    }

    @Test
    public void shouldCallFindPlayerMethodWithTheUserInputsWhenExecute() throws IOException {
        when(bufferReader.readLine()).thenReturn("Katy").thenReturn("1");
        command.execute();

        verify(league).findPlayer("Katy", "1");
    }



}