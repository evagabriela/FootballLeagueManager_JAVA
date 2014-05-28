package com.company;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        PrintStream out = System.out;
        List<Player> players = teamPlayers();

        new Team(out, players).listPlayers();
    }

    private static List<Player> teamPlayers(){
        List<Player> players = asList(new Player("Gaby", "Ohio", "3", "26"), new Player("Maria", "Chicago", "5", "28"));
        return players;
    }
}
