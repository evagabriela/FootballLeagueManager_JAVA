package com.company;

/**
 * Created by gzamudio on 5/29/14.
 */
public class ListPlayersCommand implements Command {
    private League league;

    public ListPlayersCommand(League league) {
        this.league = league;
    }

    @Override
    public void execute() {
        league.listPlayers();
    }

    @Override
    public String name() {
        return "List all the players in a team";
    }
}
