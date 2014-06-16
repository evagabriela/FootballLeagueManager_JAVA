package com.company;

import java.util.*;

public class Game {
    private Set<Team> teams;
    private Random random;
    private Map<Team, Integer> teamPointsRecord;

    public Game(){
        teams = new HashSet<Team>();
        random = new Random();
        teamPointsRecord = new HashMap<Team, Integer>();
    }

    public void getTeamsPointsRecordInAGame(){
        for (Team team: teams){
            teamPointsRecord.put(team, random.nextInt(5) + 1);
        }
    }

    public String results(Team team){
        return "Team: " + team.toString() + " Status:"+ getTeamGameStatus(team) +" Score:" + getTeamPoints(team) + " points";
    }

    public void add(Team team) {
        teams.add(team);
    }


    public String getTeamPoints(Team team){
        this.getTeamsPointsRecordInAGame();
        return String.valueOf(teamPointsRecord.get(team));
    }

    public String getTeamGameStatus(Team team){
        this.getTeamsPointsRecordInAGame();
        Integer resultPointsTeam = Integer.parseInt(getTeamPoints(team));

        if (resultPointsTeam < getMaxPointInGameResult()){
            return "Won!";
        } else if (resultPointsTeam == getMaxPointInGameResult()){
            return "Tied";
        } else {
            return "Lost";
        }

    }

    public Integer getMaxPointInGameResult(){
        this.getTeamsPointsRecordInAGame();
        Collection<Integer> values = teamPointsRecord.values();
        int result = 0;
        for (Integer value: values){
            if (value > result){
                result = value;
            }
        }
        return result;
    }


}
