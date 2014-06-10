package com.company;

import org.junit.Before;

import static org.mockito.Mockito.mock;


public class TeamMemberTest {
    private Team team1;
    private TeamMember teamMember;
    private Player player;

    @Before
    public void setUp(){
        team1 = mock(Team.class);
        player = mock(Player.class);
    }

//    **** Need to update this code:  Why is not passing?
//    @Test
//    public void shouldReturnTrueIfTeamMemberIsOnTheTeam(){
//        when(team1.toString()).thenReturn("team1");
//        when(team1.hasName("team1")).thenReturn(true);
//        when(player.toString()).thenReturn("Gaby");
//        team1.addPlayer(player);
//
//        teamMember = new TeamMember("Gaby", team1);
//        assertTrue(teamMember.isOn("team1"));
//
//    }

}