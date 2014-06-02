package com.company;

/**
 * Created by gzamudio on 5/29/14.
 */
public class ListPlayersCommand implements Command {
    private Team team;

    public ListPlayersCommand(Team team) {
        this.team = team;
    }

    @Override
    public void execute() {
        team.listPlayers();

    }

    @Override
    public String name() {
        return "List all the players in a team";
    }
}
