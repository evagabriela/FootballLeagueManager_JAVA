package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
//        ● I want to be able to list the names of all of the players in the league.
        List<Player> players = teamPlayers();
        new Team(System.out, players).listPlayers();
    }

    private static List<Player> teamPlayers(){
        List<Player> players = new ArrayList<Player>();
        Player[] arrayPlayers = {new Player("Gaby"), new Player("Maria")};
        players.addAll(asList(arrayPlayers));
        return players;
    }
}
