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
        Team team = new Team(printStream, players, coaches);

        List<Command> commands = createCommands(team, printStream, bufferedReader, done);

        Menu menu = new Menu(printStream, bufferedReader, commands, done);
        menu.chooseOption();
        while (!menu.userDone()) {
          menu.executeCurrentCommand();
          menu.chooseOption();
        }

    }

    private static Set<Coaches> teamCoaches() {
        Set<Coaches> coaches = new HashSet<Coaches>();
        coaches.add(new Coaches("Eva Atunga", "Ohio", "Head Coach"));
        coaches.add(new Coaches("Miguel Zamudio", "Ohio", "Assistance Coach"));
        return coaches;
    }

    private static List<Command> createCommands(Team team, PrintStream printStream, BufferedReader bufferedReader, DoneState done){
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(team));
        commands.add(new FindPlayerCommand(printStream, bufferedReader, team));
        commands.add(new ListTeamMembersCommand(team));
        commands.add(new TradePlayerCommand(printStream, bufferedReader, team));
        return commands;
    }

    private static List<Player> teamPlayers(){
        List<Player> players = asList(new Player("Gaby", "Ohio", "3", "26"), new Player("Maria", "Chicago", "5", "28"));
        return players;
    }
}
