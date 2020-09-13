package com.bridgelabz.ipl_analyser;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeagueAnalyser {
    Map<String,LeagueDAO> map = new HashMap();
    Comparator<LeagueDAO> comparator = null;
    List<LeagueDAO> leagueList = null;

    public int loadData(Player player, String csvFilePath) throws LeagueAnalyserException {
        map = new LeagueLoader().loadLeagueData(csvFilePath, player);
        return map.size();
    }
    public String sortData(String parameter) {
        switch (parameter) {
            case "AVG":
                comparator = Comparator.comparing(ipl -> ipl.averageScore);
                leagueList = map.values().stream().collect(Collectors.toList());
                break;
            case "STRIKE_RATE":
                comparator = Comparator.comparing(ipl -> ipl.strikeRate);
                leagueList = map.values().stream().collect(Collectors.toList());
                break;
            case "SIX_FOUR":
                comparator = Comparator.comparing(ipl -> ipl.noOfSixs + ipl.noOfFours);
                leagueList = map.values().stream().collect(Collectors.toList());
                break;
        }
        this.sort(leagueList,comparator.reversed());
        String sortedJsonData=new Gson().toJson(leagueList);
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
