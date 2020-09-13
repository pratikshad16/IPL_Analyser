package com.bridgelabz.ipl_analyser;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeagueAnalyser {
    Map<String,LeagueDAO> LeagueDAOMap = new HashMap();
    Comparator<LeagueDAO> comparator = null;
    List<LeagueDAO> leagueList = null;

    public int loadData(Player player, String csvFilePath) throws LeagueAnalyserException {
        LeagueDAOMap = new LeagueLoader().loadLeagueData(csvFilePath, player);
        return LeagueDAOMap.size();
    }
    public String sortData(String parameter) {
        switch (parameter) {
            case "AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getaverageScore()).reversed();
                break;
            case "STRIKE_RATE":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getStrikeRate()).reversed();
                break;
            case "SIX_FOUR":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getNoOfRuns())
                            .thenComparing(l -> l.getNoOfFours()).reversed();
                break;
            case "SIX_FOUR_SR":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getNoOfRuns())
                        .thenComparing(l -> l.getNoOfFours())
                        .thenComparing(l -> l.getStrikeRate()).reversed();
                break;
            case "AVG_STRIKE_RATE":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getaverageScore())
                        .thenComparing(l -> l.getStrikeRate()).reversed();
                break;
            case "RUN_AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getaverageScore())
                        .thenComparing(l -> l.getStrikeRate())
                        .thenComparing(l -> l.getNoOfRuns()).reversed();
                break;
            case "BOWLING_AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getBowlingAverageScore()).reversed();
                break;
            case "BOWLING_STRIKE_RATES":

                comparator = Comparator.comparing((LeagueDAO l) -> l.getBowlingaverageScore()).reversed();
                break;
            case "BOWLING_ECO":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getEconomy()).reversed();
                break;
            case "BOWLING_SR_4W_5W":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getStrikeRate())
                        .thenComparing(l -> l.getFoursWkts())
                        .thenComparing(l -> l.getFiveWkts()).reversed();
                break;
            case "BOWLING_SR_AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getStrikeRate())
                        .thenComparing(l -> l.getBowlingAverageScore()).reversed();
                break;
            case "BOWLING_WKTS_AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getNoOfRuns())
                        .thenComparing(l -> l.getBowlingAverageScore()).reversed();
                break;
            case "SIX_AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getaverageScore())
                        .thenComparing(l -> l.getNoOfHundreds()).reversed();
                break;

        }
        leagueList = LeagueDAOMap.values().stream().collect(Collectors.toList());
        this.sort(leagueList,comparator.reversed());
        String sortedJsonData=new Gson().toJson(leagueList);
        return sortedJsonData;
    }
    public String sortedData(Map<String,LeagueDAO> map,String parameter){
        switch (parameter) {
            case "AVG_BATTING_BOWLING":
                comparator = Comparator.comparing(ipl -> ipl.noOfRuns + ipl.bowlingAverageScore);
                comparator = Comparator.comparing((LeagueDAO l) -> l.getNoOfRuns())
                        .thenComparing(l -> l.getBowlingAverageScore()).reversed();
                break;
            case "ALL_ROUNDER":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getNoOfRuns())
                        .thenComparing(l -> l.getNoOfWickets()).reversed();
                break;
            case "AVG":
                comparator = Comparator.comparing((LeagueDAO l) -> l.getBowlingAverageScore())
                        .thenComparing(l -> l.getaverageScore()).reversed();
                break;

        }
        leagueList = map.values().stream().collect(Collectors.toList());
        this.sort(leagueList, comparator);
        String sortedJsonData = new Gson().toJson(leagueList);
        return sortedJsonData;
    }

    private void sort(List<LeagueDAO> iplList, Comparator<LeagueDAO> iplComparator) {
        IntStream.range(0, iplList.size() - 1).flatMap(i -> IntStream.range(0, iplList.size() - i - 1))
                .forEachOrdered(j -> {
                    LeagueDAO ipl1 = iplList.get(j);
                    LeagueDAO ipl2 = iplList.get(j + 1);
                    if (iplComparator.compare(ipl1, ipl2) > 0) {
                        iplList.set(j, ipl2);
                        iplList.set(j + 1, ipl1);
                    }
                });
    }
    public enum Player {
        RUNS, WKTS
    }
}
