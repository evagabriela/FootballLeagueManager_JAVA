package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DoneState done = new DoneState(false);

        List<Player> players = teamPlayers();
        Set<Coaches> coaches = teamCoaches();
        League league = new League(printStream, players, coaches);

        List<Command> commands = createCommands(league, printStream, bufferedReader, done);
        Menu menu = new Menu(printStream, bufferedReader, commands, done);
        FootballLeagueController controller = new FootballLeagueController(printStream, menu);
        
        controller.start();
    }

    private static Set<Coaches> teamCoaches() {
        Set<Coaches> coaches = new HashSet<Coaches>();
        coaches.add(new Coaches("Eva Atunga", "Ohio", "Head Coach"));
        coaches.add(new Coaches("Miguel Zamudio", "Ohio", "Assistance Coach"));
        return coaches;
    }

    private static List<Command> createCommands(League league, PrintStream printStream, BufferedReader bufferedReader, DoneState done){
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league));
        commands.add(new FindPlayerCommand(printStream, bufferedReader, league));
        commands.add(new ListTeamMembersCommand(league));
        commands.add(new TradePlayerCommand(printStream, bufferedReader, league));
        return commands;
    }

    private static List<Player> teamPlayers(){
        List<Player> players = asList(new Player("Gaby", "Ohio", "3", "26"), new Player("Maria", "Chicago", "5", "28"));
        return players;
    }
}
