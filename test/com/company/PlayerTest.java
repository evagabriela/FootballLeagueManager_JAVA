package com.company;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    private Player player;
    private Team team;

    @Before
    public void setUp(){
        player = new Player("Gaby", "Ohio", "3", "26");
        team = mock(Team.class);
    }

    @Test
    public void shouldDisplayFullPlayerInformationAsString(){
        assertEquals("Name:Gaby Team:Ohio Number:3 Age:26", player.toString());
    }

    @Test
    public void shouldReturnTrueIfPlayerNameMatchesTheOneInTheTeam(){
        when(team.findPlayer("Gaby", "3")).thenReturn(player);
        assertTrue(player.hasName("Gaby"));
    }

    @Test
    public void shouldReturnFalseIfPlayerNameDoesntMatchTheOneInTheTeam(){
        when(team.findPlayer("Gaby", "3")).thenReturn(player);
        assertFalse(player.hasName("Maria"));
    }

}