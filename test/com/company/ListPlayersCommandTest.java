package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListPlayersCommandTest {
    private League league;
    private ListPlayersCommand command;
    private PrintStream printStream;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        league = mock(League.class);
        command = new ListPlayersCommand(league, printStream);

    }

    @Test
    public void shouldDisplayMessageInAMenuOption(){
        assertEquals("List all the players in a league", command.name());
    }

    @Test
    public void shouldListAllPlayersWhenExecuteMethodIsCall(){
        command.execute();
        verify(league).getListPlayers();
    }

}