package com.bridgelabz.ipl_analyser;

import com.opencsv.bean.CsvBindByName;

public class LeagueWktsCSV {
    @CsvBindByName(column = "PLAYER")
    public String name;
    @CsvBindByName(column = "Mat")
    public int noOfMatches;
    @CsvBindByName(column = "Inns")
    public int noOfInnings;
    @CsvBindByName(column = "Ov")
    public String noOfOvers;
    @CsvBindByName(column = "Runs")
    public String noOfRuns;
    @CsvBindByName(column = "Wkts")
    public String noOfWickets;
    @CsvBindByName(column = "BBI")
    public String bbi;
    @CsvBindByName(column = "Avg")
    public String  bowlingAverageScore;
    @CsvBindByName(column = "Econ")
    public String economy;
    @CsvBindByName(column = "SR")
    public String BowlingstrikeRate;
    @CsvBindByName(column = "4w")
    public int foursWkts;
    @CsvBindByName(column = "5w")
    public int fiveWkts;

    @Override
    public String toString() {
        return "LeagueWktsCSV{" +
                "name='" + name + '\'' +
                ", noOfMatches=" + noOfMatches +
                ", noOfInnings=" + noOfInnings +
                ", noOfOvers='" + noOfOvers + '\'' +
                ", noOfRuns='" + noOfRuns + '\'' +
                ", noOfWickets='" + noOfWickets + '\'' +
                ", bbi='" + bbi + '\'' +
                ", bowlingAverageScore ='" + bowlingAverageScore + '\'' +
                ", economy='" + economy + '\'' +
                ", BowlingstrikeRate='" + BowlingstrikeRate + '\'' +
                ", foursWkts='" + foursWkts + '\'' +
                ", fiveWkts='" + fiveWkts + '\'' +
                '}';
    }
}