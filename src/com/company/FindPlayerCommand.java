package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by gzamudio on 5/29/14.
 */
public class FindPlayerCommand implements Command {
    private Team team;
    private BufferedReader bufferReader;
    private PrintStream printStream;

    public FindPlayerCommand(PrintStream printStream, BufferedReader bufferedReader, Team team) {
        this.printStream = printStream;
        this.bufferReader = bufferedReader;
        this.team = team;

    }

    @Override
    public void execute() {
        String playerName = promptedInput("Enter the name of the player");
        String playerNumber = promptedInput("Enter the number of the player");

        Player foundPlayer = team.findPlayer(playerName, playerNumber);
        if (foundPlayer != null){
            printStream.println(foundPlayer.toString());
        }else {
            printStream.println("Sorry but we couldn't find a player with the information that your provided");
        }

    }

    private String promptedInput(String prompt) {
        printStream.println(prompt);
        return readLine();
    }

    private String readLine() {
        String playerName;
        try{
            playerName = bufferReader.readLine();
        }catch (IOException e){
            throw new InputErrorIOException();
        }
        return playerName;
    }

    @Override
    public String name() {
        return "Find a player by name and number";
    }
}
