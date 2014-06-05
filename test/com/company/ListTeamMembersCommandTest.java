package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ListTeamMembersCommandTest {
    private ListTeamMembersCommand command;
    private League league;
    private PrintStream printStream;
    private BufferedReader bufferReader;

    @Before
    public void setUp(){

        league = mock(League.class);
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        command = new ListTeamMembersCommand(league, printStream, bufferReader);
    }

    @Test
    public void shouldDisplayMessageAsOptionInMenu(){
        assertEquals("List all the members of a team (players & coaches)", command.name());
    }

//    @Test
//    public void shouldListAllPlayersAndCoachesWhenExecuteMethodIsCall(){
//        command.execute();
//        verify(league).getListPlayers();
//    }

}