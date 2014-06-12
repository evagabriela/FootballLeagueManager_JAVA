package com.company;


public class Player extends TeamMember {
    private String age;
    private String number;

    public Player(String name, String number, String age, Team team) {
        super(name,team);
        this.number = number;
        this.age = age;
    }


    public String toString(){
        return "Name:" + name + " Team:" + team + " Number:" + number + " Age:" + age;
    }


    public boolean hasNameAndNumber(String name, String number){
        return this.name.equals(name) && this.number.equals(number);
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;


        if (!name.equals(player.name)) return false;
        if (!number.equals(player.number)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }
}
