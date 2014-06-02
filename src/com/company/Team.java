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
            printStream.println(player.toString());
        }
    }

    public Player findPlayer(String name, String number) {
//        if player.findByNameAndNUmber && player.number are found in the player list
        for (Player player: players){
            if (player.hasName(name) && player.hasNumber(number)){
                return player;
            }
        }

    return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!players.equals(team.players)) return false;
        if (!printStream.equals(team.printStream)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = printStream.hashCode();
        result = 31 * result + players.hashCode();
        return result;
    }
}
