package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CoachTest {
    private Coach coach;
    private Team team1;

    @Before
    public void setUp(){
        team1 = mock(Team.class);
        coach = new Coach("Eva", "Head Coach", team1 );
    }

    @Test
    public void shouldPrintCoachInformation(){
        assertEquals("Name:Eva Team:"+ team1 + " Title:Head Coach", coach.toString());
    }


}