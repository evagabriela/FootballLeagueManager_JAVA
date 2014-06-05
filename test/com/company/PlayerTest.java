package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    private Player player;
    private Team team;

    @Before
    public void setUp(){

        team = mock(Team.class);
        player = new Player("Gaby", team, "3", "26");
    }

    @Test
    public void shouldDisplayFullPlayerInformationAsString(){

        assertEquals("Name:Gaby Team:" + team+  " Number:3 Age:26", player.toString());
    }

//    @Test
//    public void shouldReturnTrueIfPlayerNameAndNumberMatchesTheOneInTheTeam(){
//        when(team.findPlayer("Gaby", "3")).thenReturn(player);
//        assertTrue(player.hasNameAndNumber("Gaby", "3"));
//    }
//
//    @Test
//    public void shouldReturnFalseIfPlayerNameDoesntMatchTheOneInTheTeam(){
//        when(team.findPlayer("Gaby", "3")).thenReturn(player);
//        assertFalse(player.hasNameAndNumber("Maria", "0"));
//    }

}