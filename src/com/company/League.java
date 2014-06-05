package com.company;

import java.util.HashSet;

public class League {
    private HashSet<Team> teams;

    public League(){
        teams = new HashSet<Team>();
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public HashSet<Team> getListTeams(){
        return teams;
    }

    public HashSet<Player> getListPlayers(){
        HashSet<Player> leaguePlayers = new HashSet<Player>();

        for (Team team: teams){
           HashSet<Player> teamPlayers = team.getListPlayers();
           for (Player player: teamPlayers){
                leaguePlayers.add(player);
           }

        }
        return leaguePlayers;
    }

    public Player findPlayer(String name, String number) throws InputErrorIOException{
        HashSet<Player> leaguePlayers = getListPlayers();
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
}
