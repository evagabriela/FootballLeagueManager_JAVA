package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;


public class Menu {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private List<Command> commands;
    private Command currentCommand;
    private DoneState done;
    private QuitCommand quitCommand = new QuitCommand(done);

    public Menu(PrintStream printStream, BufferedReader bufferedReader,  List<Command> commands, DoneState done){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.done = done;
        this.commands = commands;
        this.commands.add(quitCommand);
        currentCommand = quitCommand;
    }

    public Command listMenuOptions() throws IOException {
        printStream.println("Please select an option from the menu: ");

            listOption();

        return commands.get(readOptionSelection());
    }

    public void chooseOption() throws IOException {
        currentCommand = listMenuOptions();
    }

    public boolean userDone(){
        return currentCommand.equals(quitCommand);
    }

    public void executeCurrentCommand(){
        currentCommand.execute();
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
