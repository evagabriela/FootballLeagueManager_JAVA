package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class ListTeamMembersCommand implements Command {
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private League league;

    public ListTeamMembersCommand(League league, PrintStream printStream, BufferedReader bufferedReader) {
        this.league = league;
        this.printStream = printStream;
        this.bufferReader = bufferedReader;
    }

    @Override
    public void execute() {
        String teamName = promptedInput("Enter the team name");

        try {
            Team team = league.findTeam(teamName);
            listPlayers(team);
            team.listCoaches();
        } catch (InputErrorIOException e){
            printStream.println("Team not found");
        }

    }

    private String promptedInput(String prompt) {
        printStream.println(prompt);
        return readLine();
    }

    private String readLine() {
        String playerInfo;
        try{
            playerInfo = bufferReader.readLine();
        }catch (IOException e){
            throw new InputErrorIOException();
        }
        return playerInfo;
    }

        public void listPlayers(Team team){
        printStream.println("The members of the team are: " );
        Set<Player> players = team.getListPlayers();

        for (Player player : players){
            printStream.println(player.toString());
        }
    }

    @Override
    public String name() {
        return "List all the members of a team (players & coaches)";
    }
}
