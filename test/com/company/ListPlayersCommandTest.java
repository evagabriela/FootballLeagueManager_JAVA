package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListPlayersCommandTest {
    private Team team;
    private ListPlayersCommand command;

    @Before
    public void setUp(){
        team = mock(Team.class);
        command = new ListPlayersCommand(team);

    }

    @Test
    public void shouldDisplayMessageInAMenuOption(){
        assertEquals("List all the players in a team", command.name());
    }

    @Test
    public void shouldListAllPlayersWhenExecuteMethodIsCall(){
        command.execute();
        verify(team).listPlayers();
    }

}