package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListTeamMembersCommandTest {
    private ListTeamMembersCommand command;
    private Team team;

    @Before
    public void setUp(){
        team = mock(Team.class);
        command = new ListTeamMembersCommand(team);
    }

    @Test
    public void shouldDisplayMessageAsOptionInMenu(){
        assertEquals("List all the members of the team (players & coaches)", command.name());
    }

    @Test
    public void shouldListAllPlayersAndCoachesWhenExecuteMethodIsCall(){
        command.execute();
        verify(team).listPlayers();
        verify(team).listCoaches();
    }

}