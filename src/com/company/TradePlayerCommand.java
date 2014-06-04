package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TradePlayerCommand implements Command {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private League league;

    public TradePlayerCommand(PrintStream printStream, BufferedReader bufferedReader, League league) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.league = league;
    }

    @Override
    public void execute() {
        String playerName = promptedInput("Enter the name of the player: ");
        String playerNumber = promptedInput("Enter the number of the player: ");
        String newTeamInfo = promptedInput("Enter the name of the player's new team: ");
        league.tradePlayer(playerName, playerNumber, newTeamInfo);
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
