package com.company;

import java.io.IOException;
import java.io.PrintStream;

public class FootballLeagueController {
    private PrintStream printStream;
    private Menu menu;

    public FootballLeagueController(PrintStream printStream, Menu menu) {
        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() throws IOException {
        printStream.println("Welcome to the Football League Manager!" + "\n");
        menu.chooseOption();
        while (!menu.userDone()){
            menu.executeCurrentCommand();
            menu.chooseOption();
        }
    }
}
