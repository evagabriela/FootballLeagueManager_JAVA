package com.company;

public class Coaches {
    private String name;
    private String team;
    private String title;

    public Coaches(String name, String team, String title){
        this.name = name;
        this.team = team;
        this.title = title;
    }

    @Override
    public String toString(){
        return "Name:" + name + " Team:" + team + " Title:" + title ;
    }


}
