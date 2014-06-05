package com.company;


import org.junit.Before;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;


public class TeamTest {

    private Player player;
    private PrintStream printStream;
    private Team team;
    private  List<Player> players;
    private Set<Coach> coaches;
    private Coach coach;
    private FindPlayerCommand findPlayerCommand;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        coach = mock(Coach.class);
        coaches = new HashSet<Coach>();
        coaches.add(coach);
        players = asList(player);
        team = new Team(printStream, "team1");
        findPlayerCommand = mock(FindPlayerCommand.class);
    }

//    @Test
//    public void shouldPrintPlayersOnATeam(){
//        when(player.toString()).thenReturn("Name:Gaby Team:Ohio Number:3 Age:26");
//        List<Player> players = asList(player);
//        League team = new Team(printStream,"team1");
//        team.listPlayers();
//
//        verify(printStream).println("Name:Gaby Team:Ohio Number:3 Age:26");
//    }

//    @Test
//    public void shouldReturnCorrectPlayerWhenSearchedByNameAndNumber(){
//        Player player1 = mock(Player.class);
//        when(player1.toString()).thenReturn("Katy Michigan 1 25");
//
//        Player player2 = mock(Player.class);
//        when(player2.toString()).thenReturn("Peter California 2 23");
//
//        List<Player> players = asList(player1, player2);
//
//        Team team = new Team(printStream,"team1");
//        team.findPlayer("Katy", "1");
//
//        verify(player1).hasNameAndNumber("Katy", "1");
//    }


//    @Test
//    public void shouldReturnCoachesWhenListCoaches(){
//        when(coach.toString()).thenReturn("Eva Atunga Ohio Head Coach");
//        coaches.add(coach);
//        Team team = new Team(printStream, "team1");
//        team.listCoaches();
//        verify(printStream).println("Eva Atunga Ohio Head Coach");
//    }


//    @Test
//    public void shouldReturnInvalidMessageIfPlayerNameIsIncorrect(){
//        Player player1 = mock(Player.class);
//        when(player1.toString()).thenReturn("Katy Michigan 1 25");
//
//        Player player2 = mock(Player.class);
//        when(player2.toString()).thenReturn("Peter California 2 23");
//
//        List<Player> players = asList(player1, player2);
//
//        League league = new League(printStream, players, coaches);
//
//        findPlayerCommand.execute();
//        league.findPlayer("Katy", "3");
//
//
//        verify(printStream).println("Sorry but we couldn't find a player with the information that your provided");

//        Ideas:
//        -have another class which knows about all the teams (ex, league class knows about all the teams in the league of soccer)



}