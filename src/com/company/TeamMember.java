package com.company;

public class TeamMember {
    protected String name;
    protected Team team;

    public TeamMember(String name, Team team){
        this.name = name;
        this.team = team;
    }


    public boolean isOn(String team){
        return this.team.equals(team);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TeamMember)) return false;
//
//        TeamMember that = (TeamMember) o;
//
//        if (!name.equals(that.name)) return false;
//        if (!team.equals(that.team)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + team.hashCode();
//        return result;
//    }
}
