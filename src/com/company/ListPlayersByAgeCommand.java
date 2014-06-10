package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class ListPlayersByAgeCommand implements Command {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final League league;

    public ListPlayersByAgeCommand(PrintStream printStream, BufferedReader bufferedReader, League league) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.league = league;
    }

    @Override
    public void execute() {
        String playerAge = promptedInput("Older than what age, would you like me to list?");

        try {
            listPlayers(playerAge);

        } catch (InputErrorIOException e){
            printStream.println("Players not found");
        }

    }

    public void listPlayers(String age){
        printStream.println("The players are:" );

        Set<Player> players = league.getListPlayersOlderThan(age);

        for (Player player : players){

            printStream.println(player.toString());
        }
    }

    private String promptedInput(String prompt) {
        printStream.println(prompt);
        return readLine();
    }

    private String readLine() {
        String playerInfo;
        try{
            playerInfo = bufferedReader.readLine();
        }catch (IOException e){
            throw new InputErrorIOException();
        }
        return playerInfo;
    }


    @Override
    public String name() {
        return "List all the players older than...";
    }
}
