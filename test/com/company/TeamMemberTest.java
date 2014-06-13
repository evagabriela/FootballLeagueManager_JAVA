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
        teamMember = new TeamMember("Gaby", team1);
        player = mock(Player.class);
    }

////    **** Need to update this code:  Why is not passing?
//    @Test
//    public void shouldReturnTrueIfTeamMemberIsInTeamInput(){
////        HashSet<Player> players = new HashSet<Player>();
//        when(team1.toString()).thenReturn("team1");
//        when(player.toString()).thenReturn("Gaby");
////        players.add(player);
//        when(team1.hasName("team1")).thenReturn(true);
////        when(team1.getListPlayers()).thenReturn(players);
//        team1.addPlayer(player);
//        assertTrue(teamMember.isOn("team1"));
//    }



}