package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//I want to continue choosing options until I choose to Quit
public class QuitCommandTest {

    private QuitCommand command;
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private DoneState done;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        done = mock(DoneState.class);
        command = new QuitCommand(done);
    }

    @Test
    public void shouldDisplayAMessageAfterChosenQuitOption(){
        assertEquals("Exit", command.name());
    }

    @Test
    public void shouldExecuteMethodIsCall() throws IOException {
        when(bufferReader.readLine()).thenReturn("3");
        command.execute();
        verify(done).isDone();
    }


}