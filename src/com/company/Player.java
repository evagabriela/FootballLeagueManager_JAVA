package com.company;

/**
 * Created by gzamudio on 5/27/14.
 */

public class Player {
    private String age;
    private String number;
    private String name;
    private String team;

    public Player(String name, String team, String number, String age) {
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Name:" + name + " Team:" + team + " Number:" + number + " Age:" + age;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public boolean hasNumber(String number){
        return this.number.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!age.equals(player.age)) return false;
        if (!name.equals(player.name)) return false;
        if (!number.equals(player.number)) return false;
        if (!team.equals(player.team)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + team.hashCode();
        return result;
    }
}
