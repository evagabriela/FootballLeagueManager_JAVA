package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ListGameResultsCommand implements Command {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Game game;

    public ListGameResultsCommand(PrintStream printStream, BufferedReader bufferedReader, Game game) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.game = game;
    }

    @Override
    public void execute() {

        String teamName = promptedInput("What team result's do you want to see");

        try{
            Team team = game.getTeam(teamName);
            printStream.println(game.results(team));
        } catch (InputErrorIOException e){
            printStream.println("Team not found in game");
        }
    }

    private String promptedInput(String prompt) {
        printStream.println(prompt);
        return readLine();
    }

    private String readLine() {
        String teamInfo;
        try{
            teamInfo = bufferedReader.readLine();
        }catch (IOException e){
            throw new InputErrorIOException();
        }
        return teamInfo;
    }

    @Override
    public String name() {
        return "List the results of a Game";
    }
}
