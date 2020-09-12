package com.bridgelabz.ipl_analyser;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class LeagueAnalyser {
    Map<String,LeagueDAO> map = new HashMap();


    public int loadData(Player player, String csvFilePath) throws LeagueAnalyserException {
        map = new LeagueLoader().loadLeagueData(csvFilePath, player);
        return map.size();
    }

    public String sortData() {
        Comparator<LeagueDAO> comparator = Comparator.comparing(ipl -> ipl.name);
        List<LeagueDAO> leagueList = map.values().stream().collect(Collectors.toList());
        Collections.sort(leagueList, comparator);
        String sortedJsonData=new Gson().toJson(leagueList);
        return sortedJsonData;
    }

    public enum Player {
        RUNS, WKTS
    }

}
