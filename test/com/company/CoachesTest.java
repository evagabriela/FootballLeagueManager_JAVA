package com.company;

import org.junit.Test;

/*
I want the list of all players in the league to also list all of the coaches in the league.
 Coaches are not be findable like players are. Coaches have a name, team, and title.
 */
public class CoachesTest {

    @Test
    public void shouldListCoachesWhenListPlayersFromTheSameTeam(){
        Coaches coaches = new Coaches("Eva", "Ohio", "Head Coach");
    }


}