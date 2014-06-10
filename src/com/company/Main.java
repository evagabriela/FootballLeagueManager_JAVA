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

        String fileTeamOneFile = "resources/team1InputFile.txt";
        String fileTeamTwoFile = "resources/team2InputFile.txt";

        TeamParser teamParser1 = new TeamParser(fileTeamOneFile, printStream);
        TeamParser teamParser2 = new TeamParser(fileTeamTwoFile, printStream);

        Team team1 = teamParser1.buildTeamOneSetUp();
        Team team2 = teamParser2.buildTeamOneSetUp();

        league.addTeam(team1);
        league.addTeam(team2);


        List<Command> commands = createCommands(league, printStream, bufferedReader, done);
        Menu menu = new Menu(printStream, bufferedReader, commands, done);
        FootballLeagueController controller = new FootballLeagueController(printStream, menu);

        controller.start();
    }




    private static List<Command> createCommands(League league, PrintStream printStream, BufferedReader bufferedReader, DoneState done){
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListPlayersCommand(league,printStream));
        commands.add(new FindPlayerCommand(printStream, bufferedReader, league));
        commands.add(new ListTeamMembersCommand(league,printStream,bufferedReader));
        commands.add(new TradePlayerCommand(printStream, bufferedReader, league));
        commands.add(new ListPlayersByAgeCommand(printStream, bufferedReader, league));

        return commands;
    }


}
