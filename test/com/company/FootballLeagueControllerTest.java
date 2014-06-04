package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class FootballLeagueControllerTest {
    private PrintStream printStream;
    private Menu menu;
    private FootballLeagueController controller;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        controller = new FootballLeagueController(printStream,menu);
    }

    @Test
    public void shouldPrintMessageOnStart() throws IOException {
        when(menu.userDone()).thenReturn(true);
        controller.start();
        verify(printStream).println("Welcome to the Football League Manager!" + "\n");
    }

    @Test
    public void shouldRunMenuWhenControllerStarts() throws IOException {
        when(menu.userDone()).thenReturn(true);
        controller.start();
        verify(menu).chooseOption();
    }

    @Test
    public void shouldQuitWhenOptionSelected() throws IOException {
        when(menu.userDone()).thenReturn(false).thenReturn(true);
        controller.start();
        verify(menu, times(2)).chooseOption();
    }

}