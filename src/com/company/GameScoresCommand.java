package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class GameScoresCommand implements Command {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Game game;

    public GameScoresCommand(PrintStream printStream, BufferedReader bufferedReader, Game game) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.game = game;
    }


    @Override
    public void execute() {
        String teamName = promptedInput ("Enter the name of the team");
        String scoreInput = promptedInput("Enter the score");

        Team foundTeam = game.getTeam(teamName);
        if (foundTeam != null){
            game.getTeamsPointsRecordInAGame(foundTeam, scoreInput);
        } else {
            printStream.println("Invalid Entry");
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
        return "Game Scores Input";
    }
}
