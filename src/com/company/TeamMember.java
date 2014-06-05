package com.company;

public class TeamMember {
    protected String name;
    protected Team team;

    public TeamMember(String name, Team team){
        this.name = name;
        this.team = team;
    }

    public boolean hasName(String name){
        return this.name.equals(name);
    }

    public boolean isOn(String team){
        return this.team.equals(team);
    }


}
