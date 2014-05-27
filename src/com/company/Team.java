package com.company;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by gzamudio on 5/27/14.
 */
public class Team {
    private final PrintStream printStream;
    private final List<Player> players;

    public Team(PrintStream printStream, List<Player> players) {
        this.printStream = printStream;
        this.players = players;
    }

    public void listPlayers(){
        for (Player player : players){
            printStream.println(player);
        }
    }

}
