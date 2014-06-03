package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TradePlayerCommand implements Command {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Team team;

    public TradePlayerCommand(PrintStream printStream, BufferedReader bufferedReader, Team team) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.team = team;
    }

    @Override
    public void execute() {
        String playerName = promptedInput("Enter the name of the player: ");
        String playerNumber = promptedInput("Enter the number of the player: ");
        String newTeamInfo = promptedInput("Enter the name of the player's new team: ");
        team.tradePlayer(playerName, playerNumber, newTeamInfo);
//        here I can do display player ex. team.displayPlayer(playerName, playerNumber)


    }

    private String promptedInput(String prompt){
        printStream.println(prompt);
        return readLine();
    }

    private String readLine(){
        String playerInfo;
        try {
            playerInfo = bufferedReader.readLine();
        } catch (IOException e){
            throw new InputErrorIOException();
        }
        return playerInfo;
    }

    @Override
    public String name() {
        return "Trade Player";
    }
}
