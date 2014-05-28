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
}
