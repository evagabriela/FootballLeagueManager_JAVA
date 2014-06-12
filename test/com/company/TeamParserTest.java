package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamParserTest {

    private PrintStream printStream;
    private String fileName;
    private TeamParser teamParser;
    private League league;
    private Team team;
    private BufferedReader bufferedReader;

    @Before
    public void setUp(){
        fileName = "abc";
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        teamParser = new TeamParser(fileName, printStream);
        team = mock(Team.class);
    }

    @Test
    public void shouldReturnATeamWithTheRightName() throws IOException {
        when(bufferedReader.readLine()).thenReturn("team1").thenReturn("Eva, Head Coach").thenReturn("Gaby,3,26").thenReturn(null);
        Team testTeam = teamParser.parseFile(bufferedReader);

        assertEquals("team1", testTeam.toString() );
    }

    @Test
    public void shouldReturnATeamWithACoach() throws IOException {
        when(bufferedReader.readLine()).thenReturn("team1").thenReturn("Eva, Head Coach").thenReturn("Gaby,3,26").thenReturn(null);
        Team testTeam = teamParser.parseFile(bufferedReader);
        Coach coach = new Coach("Eva"," Head Coach", team);

        assertTrue(testTeam.getListCoaches().contains(coach));
    }

    @Test
    public void shouldReturnATeamWithAPlayer() throws IOException {
        when(bufferedReader.readLine()).thenReturn("team1").thenReturn("Eva, Head Coach").thenReturn("Eva, Head Coach").thenReturn("Gaby,3,26").thenReturn(null);
        Team testTeam = teamParser.parseFile(bufferedReader);
        Player player = new Player("Gaby", "3", "26", team);

        assertTrue(testTeam.getListPlayers().contains(player));
    }

    @Test
    public void shouldReturnATeam() throws IOException {
        when(bufferedReader.readLine()).thenReturn("team1").thenReturn("Eva, Head Coach").thenReturn("Eva, Head Coach").thenReturn("Gaby,3,26").thenReturn(null);
        Team testTeam = teamParser.parseFile(bufferedReader);
        Team team = new Team(printStream, "team1");
        Coach coach = new Coach("Eva"," Head Coach", team);
        Player player = new Player("Gaby", "3", "26", team);
        team.addCoach(coach);
        team.addPlayer(player);

        assertEquals(team, testTeam);
    }

}