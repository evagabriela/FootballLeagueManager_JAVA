package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListLeagueMembersCommandTest {
    private ListTeamMembersCommand command;
    private League league;

    @Before
    public void setUp(){
        league = mock(League.class);
        command = new ListTeamMembersCommand(league);
    }

    @Test
    public void shouldDisplayMessageAsOptionInMenu(){
        assertEquals("List all the members of the team (players & coaches)", command.name());
    }

    @Test
    public void shouldListAllPlayersAndCoachesWhenExecuteMethodIsCall(){
        command.execute();
        verify(league).listPlayers();
        verify(league).listCoaches();
    }

}