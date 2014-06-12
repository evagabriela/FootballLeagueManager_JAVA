package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private List<Command> commands;
    private Menu menu;
    private Command someCommand;
    private DoneState done;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        commands = new ArrayList<Command>();
        someCommand = mock(Command.class);
//        commands.add(someCommand);

        menu = new Menu(printStream, bufferedReader, commands, done);
    }

    @Test
    public void shouldPrintMessageToSelectOptionFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.listMenuOptions();

        verify(printStream).println("Please select an option from the menu: ");
    }


//    @Test
//    public void shouldExecuteListPlayerCommandWhenOptionOneWasChosen() throws IOException {
//        System.out.println("after removing the quit command " + commands);
//        when(done.isDone()).thenReturn(true);
//        when(bufferedReader.readLine()).thenReturn("1");
//        menu.listMenuOptions();
//        menu.executeCurrentCommand();
//
//        verify(commands.get(0)).execute();
//    }

//    @Test
//    public void shouldExecuteFindPlayerCommandWhenOptionTwoWasChosenFromMenu() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("2");
//        Command secondCommand = mock(Command.class);
//        commands.add(secondCommand);
//
//        menu.listMenuOptions();
//        verify(secondCommand).execute();
//
//    }

//    @Test
//    public void shouldExecuteQuiteWhenOptionThreeWasChosenFromMenu() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("3");
//        Command thirdCommand = mock(Command.class);
//        commands.add(thirdCommand);
//
//        menu.listMenuOptions();
//        verify(thirdCommand).execute();
//
//    }



}