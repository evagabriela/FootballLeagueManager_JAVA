package com.company;

import java.util.*;

public class Game {
    private Set<Team> teams;
    private Map<Team, Integer> teamPointsRecord;

    public Game(){
        teams = new HashSet<Team>();
        teamPointsRecord = new HashMap<Team, Integer>();
    }

    public Map<Team, Integer> getTeamsPointsRecordInAGame(Team teamName, String scoreInput){
        Integer scorePoints = Integer.parseInt(scoreInput);
        teamPointsRecord.put(teamName, scorePoints);
        return  teamPointsRecord;
    }

    public String results(Team team){
        return "Team " + team.toString() + " Score " + getTeamPoints(team) + " Game Status " + getTeamGameStatus(team);
    }

    public void add(Team team) {
        teams.add(team);
    }

    public String getTeamPoints(Team team){
        return String.valueOf(teamPointsRecord.get(team));
    }

    public Integer getMaxPointInGameResult(){
        Collection<Integer> values = teamPointsRecord.values();
        int result = 0;
        for (Integer value: values){
            if (value > result){
                result = value;
            }
        }
        return result;
    }

    public String getTeamGameStatus(Team team){
        Integer resultPointsTeam = Integer.parseInt(getTeamPoints(team));

        if (resultPointsTeam == getMaxPointInGameResult()){
            return "Won!";
        } else if (resultPointsTeam < getMaxPointInGameResult()){
            return "Lost";
        } else {
            return "Tied!";
        }

    }

    public Team getTeam(String teamName) {
        for (Team team: teams){
            if (team.hasName(teamName)){
                return team;
            }
        }
        throw new InputErrorIOException();
    }
}
