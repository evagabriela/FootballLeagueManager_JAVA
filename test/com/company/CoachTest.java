package com.company;

import org.junit.Test;

import static org.mockito.Mockito.mock;

/*
I want the list of all players in the league to also list all of the coaches in the league.
 Coaches are not be findable like players are. Coaches have a name, team, and title.
 */
public class CoachTest {

    private Team team;

    @Test
    public void shouldListCoachesWhenListPlayersFromTheSameTeam(){
        team = mock(Team.class);
        Coach coach = new Coach("Eva", team, "Head Coach");
    }


}