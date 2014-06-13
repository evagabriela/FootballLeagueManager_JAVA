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
        commands.add(someCommand);

        menu = new Menu(printStream, bufferedReader, commands, done);
    }

    @Test
    public void shouldPrintMessageToSelectOptionFromMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.listMenuOptions();

        verify(printStream).println("Please select an option from the menu: ");
    }


    @Test
    public void shouldExecuteListPlayerCommandWhenOptionOneWasChosen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        menu.chooseOption();
        menu.executeCurrentCommand();

        verify(someCommand).execute();
    }

//    Need to add when Invalid input (Where do I add the try and catch or how to handle IOException?
//    @Test
//    public void shouldReturnAnErrorMessageIfInvalidOption() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("0");
//
////        menu.executeCurrentCommand();
//        assertEquals("bla", menu.listMenuOptions());
//
//    }




}