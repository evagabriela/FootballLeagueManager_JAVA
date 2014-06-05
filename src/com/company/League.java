package com.company;

import java.util.HashSet;
import java.util.Set;

public class League {
    private Set<Team> teams;

    public League(){
        teams = new HashSet<Team>();
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public Set<Team> getListTeams(){
        return teams;
    }

    public Set<Player> getListPlayers(){
        Set<Player> leaguePlayers = new HashSet<Player>();

        for (Team team: teams){
           Set<Player> teamPlayers = team.getListPlayers();
           for (Player player: teamPlayers){
                leaguePlayers.add(player);
           }

        }
        return leaguePlayers;
    }

    public Player findPlayer(String name, String number) throws InputErrorIOException{
        Set<Player> leaguePlayers = getListPlayers();
        for (Player player: leaguePlayers){
            if (player.hasNameAndNumber(name, number)){
                return player;
            }

        }

        throw new InputErrorIOException();
    }

    public Team findTeam(String name) throws InputErrorIOException{
        for (Team team: teams){
            if (team.hasName(name)){
                return team;
            }
        }
        throw new InputErrorIOException();
    }


    public void tradePlayer(Player player, Team team) {
        Team oldTeam = player.getTeam();
        oldTeam.removePlayer(player);
        team.addPlayer(player);
        player.setTeam(team);
    }

    public Set<Player> getListPlayersOlderThan(String age) {
        Set<Player> playersOlderThan = new HashSet<Player>();

        for (Team team: teams){
            Set<Player> teamPlayers = team.getListPlayers();
            for (Player player: teamPlayers){

                if (Integer.parseInt(player.getAge()) > Integer.parseInt(age)){
                    playersOlderThan.add(player);
                }
            }
        }

        return playersOlderThan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof League)) return false;

        League league = (League) o;

        if (!teams.equals(league.teams)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return teams.hashCode();
    }
}
