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
    public String  averageScore;
    @CsvBindByName(column = "Econ")
    public String economy;
    @CsvBindByName(column = "SR")
    public String strikeRate;
    @CsvBindByName(column = "4w")
    public String foursWkts;
    @CsvBindByName(column = "5w")
    public String fiveWkts;

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
                ", averageScore=" + averageScore +
                ", economy='" + economy + '\'' +
                ", strikeRate='" + strikeRate + '\'' +
                ", foursWkts='" + foursWkts + '\'' +
                ", fiveWkts='" + fiveWkts + '\'' +
                '}';
    }
}