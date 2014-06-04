package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListPlayersCommandTest {
    private League league;
    private ListPlayersCommand command;

    @Before
    public void setUp(){
        league = mock(League.class);
        command = new ListPlayersCommand(league);

    }

    @Test
    public void shouldDisplayMessageInAMenuOption(){
        assertEquals("List all the players in a team", command.name());
    }

    @Test
    public void shouldListAllPlayersWhenExecuteMethodIsCall(){
        command.execute();
        verify(league).listPlayers();
    }

}