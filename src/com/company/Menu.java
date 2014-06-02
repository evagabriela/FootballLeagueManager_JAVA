package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by gzamudio on 5/29/14.
 */
public class Menu {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final List<Command> commands;

    public Menu(PrintStream printStream, BufferedReader bufferedReader,  List<Command> commands){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.commands = commands;
    }

    public Command listMenuOptions() throws IOException {
        printStream.println("Please select an option from the menu: ");
        listOption();

        return commands.get(readOptionSelection());
    }

    private int readOptionSelection() throws IOException {
        String input = bufferedReader.readLine();
        return Integer.parseInt(input) - 1;
    }

    private void listOption() {
        int optionNumber = 1;
        for (Command command: commands){
            printStream.println(optionNumber++ + ". " + command.name());
        }
    }

}
