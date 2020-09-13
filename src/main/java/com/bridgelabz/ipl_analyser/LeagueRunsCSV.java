package com.bridgelabz.ipl_analyser;

import com.opencsv.bean.CsvBindByName;

public class LeagueRunsCSV {
    @CsvBindByName(column = "PLAYER")
    public String name;
    @CsvBindByName(column = "Mat")
    public int noOfMatches;
    @CsvBindByName(column = "Inns")
    public int noOfInnings;
    @CsvBindByName(column = "Runs")
    public int noOfRuns;
    @CsvBindByName(column = "HS")
    public int highestScore;
    @CsvBindByName(column = "BF")
    public int noOfBallFaced;
    @CsvBindByName(column = "Avg")
    public String averageScore;
    @CsvBindByName(column = "SR")
    public String strikeRate;
    @CsvBindByName(column = "100")
    public int noOfHundreds;
    @CsvBindByName(column = "50")
    public int noOfFifty;
    @CsvBindByName(column = "4s")
    public int noOfFours;
    @CsvBindByName(column = "6s")
    public int noOfSixs;

    @Override
    public String toString() {
        return "LeagueRunsCSV{" +
                "name='" + name + '\'' +
                ", noOfMatches=" + noOfMatches +
                ", noOfInnings=" + noOfInnings +
                ", noOfRuns=" + noOfRuns +
                ", highestScore=" + highestScore +
                ", noOfBallFaced=" + noOfBallFaced +
                ", averageScore='" + averageScore + '\'' +
                ", strikeRate='" + strikeRate + '\'' +
                ", noOfHundreds=" + noOfHundreds +
                ", noOfFifty=" + noOfFifty +
                ", noOfFours=" + noOfFours +
                ", noOfSixs=" + noOfSixs +
                '}';
    }
}
