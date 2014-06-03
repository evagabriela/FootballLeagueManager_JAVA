package com.company;

import java.io.PrintStream;
import java.util.List;
import java.util.Set;

/**
 * Created by gzamudio on 5/27/14.
 */
public class Team {
    private PrintStream printStream;
    private List<Player> players;
    private Set<Coaches> coaches;

    public Team(PrintStream printStream, List<Player> players, Set<Coaches> coaches) {
        this.printStream = printStream;
        this.players = players;
        this.coaches = coaches;
    }

    public void listPlayers(){
        printStream.println("The members of the team are: " );
        for (Player player : players){
            printStream.println(player.toString());
        }
    }

    public Player findPlayer(String name, String number) {
        for (Player player: players){
            if (player.hasName(name) && player.hasNumber(number)){
                return player;
            }
        }

    return null;
    }

    public void listCoaches(){

        for (Coaches coach : coaches){
            printStream.println(coach.toString());
        }
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

    public void tradePlayer(String playerName, String playerNumber, String newTeamInfo) {
        Player foundPlayer = findPlayer(playerName, playerNumber);
//pending to add the logic on how am I going to add players to a new team
//        Ideas:
//        -have another class which knows about all the teams (ex, league class knows about all the teams in the league of soccer)
    }
}
