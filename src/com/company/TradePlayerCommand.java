package com.company;

import java.io.BufferedReader;
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

    }

    @Override
    public String name() {
        return "Trade Player";
    }
}
