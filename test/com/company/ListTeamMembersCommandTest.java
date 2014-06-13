package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ListTeamMembersCommandTest {
    private ListTeamMembersCommand command;
    private League league;
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private List<Command> commands;
    private Team team;
    private Command someCommand;
    private Player player;
    private Coach coach;

    @Before
    public void setUp(){

        league = mock(League.class);
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        command = new ListTeamMembersCommand(league, printStream, bufferReader);
        someCommand = mock(Command.class);
        team = mock(Team.class);
        player = mock(Player.class);
        coach = mock(Coach.class);


    }

    @Test
    public void shouldDisplayMessageAsOptionInMenu(){
        assertEquals("List all the members of a team (players & coaches)", command.name());
    }

//    @Test
//    public void shouldListAllPlayersAndCoachesWhenExecuteMethodIsCall(){
//        Command firstCommand = mock(Command.class);
////        commands.add(firstCommand);
////        when(bufferedReader.readLine()).thenReturn("1");
////        menu.executeCurrentCommand();
//        team = mock(Team.class);
//        when(league.findTeam("team1")).thenReturn(team);
//        commands.execute();
//        verify(league).getListPlayers();
//    }

}