package com.company;

public class Coach extends TeamMember {
    private String title;

    public Coach(String name, String title, Team team){
        super(name,team);
        this.title = title;
    }

    @Override
    public String toString(){
        return "Name:" + name + " Team:" + team + " Title:" + title ;
    }


}
