package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DoneState done = new DoneState(false);
        League league = new League();
        Team team1 = buildTeam1(printStream);
        Team team2 = buildTeam2(printStream);
        league.addTeam(team1);
        league.addTeam(team2);


        List<Command> commands = createCommands(team1, league, printStream, bufferedReader, done);
        Menu menu = new Menu(printStream, bufferedReader, commands, done);
        FootballLeagueController controller = new FootballLeagueController(printStream, menu);

        controller.start();
    }

    private static Team buildTeam1(PrintStream printStream){
        Team team1 = new Team(printStream,"team1");
        Player player1 = new Player("Gaby", team1, "3", "21");
        Player player2 = new Player("Maria", team1, "1", "30");
        team1.addPlayer(player1);
        team1.addPlayer(player2);

        Coach coach1 = new Coach("Eva", team1, "Head Coach");
        Coach coach2 = new Coach("Miguel", team1, "Assistance Coach");
        team1.addCoach(coach1);
        team1.addCoach(coach2);

        return team1;
    }

    private static Team buildTeam2(PrintStream printStream){
        Team team2 = new Team(printStream,"team2");
        Player player1 = new Player("Keith", team2, "2", "27");
        Player player2 = new Player("Mario", team2, "4", "38");
        team2.addPlayer(player1);
        team2.addPlayer(player2);

        Coach coach1 = new Coach("Wayne", team2, "Head Coach");
        Coach coach2 = new Coach("Liz", team2, "Assistance Coach");
        team2.addCoach(coach1);
        team2.addCoach(coach2);

        return team2;
    }



    private static List<Command> createCommands(Team team, League league, PrintStream printStream, BufferedReader bufferedReader, DoneState done){
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league,printStream));
        commands.add(new FindPlayerCommand(printStream, bufferedReader, league));
        commands.add(new ListTeamMembersCommand(league,printStream,bufferedReader));
        commands.add(new TradePlayerCommand(printStream, bufferedReader, league));
        commands.add(new ListPlayersByAgeCommand(printStream, bufferedReader, league));

        return commands;
    }


}
