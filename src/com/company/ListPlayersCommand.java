package com.company;

import java.io.PrintStream;
import java.util.Set;

/**
 * Created by gzamudio on 5/29/14.
 */
public class ListPlayersCommand implements Command {
    private PrintStream printStream;
    private League league;

    public ListPlayersCommand(League league, PrintStream printStream) {
        this.league = league;
        this.printStream =printStream;
    }

    @Override
    public void execute() {
        Set<Player> players =  league.getListPlayers();

        for (Player player: players ){
            printStream.println(player);
        }

    }

    @Override
    public String name() {
        return "List all the players in a league";
    }
}
