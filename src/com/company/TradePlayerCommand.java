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

        Player player1 = league.findPlayer(playerName, playerNumber);

        String newTeamInfo = promptedInput("Enter the name of the player's new team: ");

        Team team1 = league.findTeam(newTeamInfo);
        league.tradePlayer(player1, team1);


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
