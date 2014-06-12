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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;

        Coach coach = (Coach) o;

        if (!title.equals(coach.title)) return false;

        return true;
    }


        @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}
