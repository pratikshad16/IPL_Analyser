package com.bridgelabz.ipl_analyser;

public class LeagueDAO {
    public String name;
    public int noOfMatches;
    public int noOfInnings;
    public int noOfRuns;
    public int highestScore;
    public int noOfBallFaced;
    public String averageScore;
    public String strikeRate;
    public String bowlingAverageScore;
    public int noOfHundreds;
    public int noOfFifty;
    public int noOfFours;
    public int noOfSixs;
    public String noOfOvers;
    public String noOfWickets;
    public String bbi;
    public String economy;
    public String fourWkts;
    public String fiveWkts;
    public String BowlingstrikeRate;

    public LeagueDAO(LeagueRunsCSV leagueRunsCSV) {
        name = leagueRunsCSV.name;
        noOfMatches = leagueRunsCSV.noOfMatches;
        noOfInnings = leagueRunsCSV.noOfInnings;
        noOfRuns = leagueRunsCSV.noOfRuns;
        highestScore = leagueRunsCSV.highestScore;
        noOfBallFaced = leagueRunsCSV.noOfBallFaced;
        averageScore = leagueRunsCSV.averageScore;
        strikeRate = leagueRunsCSV.strikeRate;
        noOfHundreds = leagueRunsCSV.noOfHundreds;
        noOfFifty = leagueRunsCSV.noOfFifty;
        noOfFours = leagueRunsCSV.noOfFours;
        noOfSixs = leagueRunsCSV.noOfSixs;
    }

    public LeagueDAO(LeagueWktsCSV leagueWktsCSV) {
        name = leagueWktsCSV.name;
        noOfMatches = leagueWktsCSV.noOfMatches;
        noOfInnings = leagueWktsCSV.noOfInnings;
        noOfOvers = leagueWktsCSV.noOfOvers;
        noOfWickets = leagueWktsCSV.noOfWickets;
        bbi = leagueWktsCSV.bbi;
        economy = leagueWktsCSV.economy;
        fiveWkts = leagueWktsCSV.fiveWkts;
        fourWkts = leagueWktsCSV.foursWkts;
        bowlingAverageScore = leagueWktsCSV.bowlingAverageScore;
        BowlingstrikeRate = leagueWktsCSV.BowlingstrikeRate;
    }
    public LeagueDAO(LeagueDAO leagueWktsCSV, LeagueDAO leagueRunsCSV) {
        name = leagueWktsCSV.name;
        noOfMatches = leagueWktsCSV.noOfMatches;
        noOfInnings = leagueWktsCSV.noOfInnings;
        noOfOvers = leagueWktsCSV.noOfOvers;
        noOfWickets = leagueWktsCSV.noOfWickets;
        bbi = leagueWktsCSV.bbi;
        economy = leagueWktsCSV.economy;
        fiveWkts = leagueWktsCSV.fiveWkts;
        fourWkts = leagueWktsCSV.fourWkts;
        bowlingAverageScore = leagueWktsCSV.bowlingAverageScore;
        noOfRuns = leagueWktsCSV.noOfRuns;
        name = leagueRunsCSV.name;
        noOfMatches = leagueRunsCSV.noOfMatches;
        noOfInnings = leagueRunsCSV.noOfInnings;
        noOfRuns = leagueRunsCSV.noOfRuns;
        highestScore = leagueRunsCSV.highestScore;
        noOfBallFaced = leagueRunsCSV.noOfBallFaced;
        averageScore = leagueRunsCSV.averageScore;
        strikeRate = leagueRunsCSV.strikeRate;
        noOfHundreds = leagueRunsCSV.noOfHundreds;
        noOfFifty = leagueRunsCSV.noOfFifty;
        noOfFours = leagueRunsCSV.noOfFours;
        noOfSixs = leagueRunsCSV.noOfSixs;

    }
}

