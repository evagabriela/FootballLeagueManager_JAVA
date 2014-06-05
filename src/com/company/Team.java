package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Team {
    private PrintStream printStream;
    private String name;
    private Set<Player> players;
    private Set<Coach> coaches;

    public Team(PrintStream printStream, String name) {
        this.printStream = printStream;
        this.name = name;
        players = new HashSet<Player>();
        coaches = new HashSet<Coach>();

    }

    public String toString(){
        return name;
    }



    public Set<Player> getListPlayers(){
        return players;
    }

    public void listCoaches(){
        for (Coach coach : coaches){
            printStream.println(coach.toString());
        }
    }

    public Set<Coach> getListCoaches(){
        return coaches;
    }

    public void addPlayer(Player player1) {
        players.add(player1);
    }

    public void removePlayer(Player player) {
        players.remove(player);

    }

    public void addCoach(Coach coach1) {
        coaches.add(coach1);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public List<TeamMember> team(String teamName){
        List<TeamMember> team = new ArrayList<TeamMember>();
        for (TeamMember player: players){
            if (player.isOn(teamName)){
                team.add(player);
            }
        }

        for (TeamMember coach: coaches){
            if (coach.isOn(teamName)){
                team.add(coach);
            }
        }
        return team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!coaches.equals(team.coaches)) return false;
        if (!name.equals(team.name)) return false;
        if (!players.equals(team.players)) return false;
        if (!printStream.equals(team.printStream)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = printStream.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + players.hashCode();
        result = 31 * result + coaches.hashCode();
        return result;
    }
}
