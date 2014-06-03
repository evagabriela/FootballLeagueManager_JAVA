package com.company;

public class ListTeamMembers implements Command {
    private Team team;

    public ListTeamMembers(Team team) {
        this.team = team;
    }

    @Override
    public void execute() {
        team.listPlayers();
        team.listCoaches();
    }

    @Override
    public String name() {
        return "List all the members of the team (players & coaches)";
    }
}
