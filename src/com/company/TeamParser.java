package com.company;

import java.io.*;

public class TeamParser {
    private final String fileName;
    private final PrintStream printStream;

    public TeamParser(String fileName, PrintStream printStream){
        this.fileName = fileName;
        this.printStream = printStream;
    }

    public Team buildTeamOneSetUp() throws IOException {
        FileReader inputFile = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        Team team = parseFile(bufferedReader);
        bufferedReader.close();
        return team;
    }

    public Team parseFile(BufferedReader bufferedReader) throws IOException {
        String line;
        line = bufferedReader.readLine();
        Team team = new Team(printStream, line);

        line = bufferedReader.readLine();
        Coach coach1 = createCoach(line, team);
        team.addCoach(coach1);

        line = bufferedReader.readLine();
        Coach coach2 = createCoach(line, team);
        team.addCoach(coach2);

        while ((line = bufferedReader.readLine()) != null){
          Player player = createPlayer(line, team);
          team.addPlayer(player);
        }
        return team;
    }

    public Coach createCoach(String info, Team team){
        String[] linePieces = info.split(",");
        return new Coach(linePieces[0], linePieces[1], team);
    }

    public Player createPlayer(String info, Team team){
        String[] linePieces = info.split(",");
        return new Player(linePieces[0], linePieces[1], linePieces[2], team);
    }

}
