package com.company;

public class ListTeamMembersCommand implements Command {
    private League league;

    public ListTeamMembersCommand(League league) {
        this.league = league;
    }

    @Override
    public void execute() {
        league.listPlayers();
        league.listCoaches();
    }

    @Override
    public String name() {
        return "List all the members of the team (players & coaches)";
    }
}
