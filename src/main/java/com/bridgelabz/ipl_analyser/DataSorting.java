//package com.bridgelabz.ipl_analyser;
//
//import com.google.gson.Gson;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//
//public class DataSorting {
//    static Comparator<LeagueDAO> comparator = null;
//    static List<LeagueDAO> leagueList = null;
//
//    public static String sortData(String parameter, Map<String, LeagueDAO> leagueDAOMap) {
//
//        switch (parameter) {
//            case "AVG":
//                comparator = Comparator.comparing(LeagueDAO::getaverageScore).reversed();
//                break;
//            case "STRIKE_RATE":
//                comparator = Comparator.comparing(LeagueDAO::getStrikeRate).reversed();
//                break;
//            case "SIX_FOUR":
//                comparator = Comparator.comparing(LeagueDAO::getNoOfRuns)
//                        .thenComparing(LeagueDAO::getNoOfFours).reversed();
//                break;
//            case "SIX_FOUR_SR":
//                comparator = Comparator.comparing(LeagueDAO::getNoOfRuns)
//                        .thenComparing(LeagueDAO::getNoOfFours)
//                        .thenComparing(LeagueDAO::getStrikeRate).reversed();
//                break;
//            case "AVG_STRIKE_RATE":
//                comparator = Comparator.comparing(LeagueDAO::getaverageScore)
//                        .thenComparing(LeagueDAO::getStrikeRate).reversed();
//                break;
//            case "RUN_AVG":
//                comparator = Comparator.comparing(LeagueDAO::getaverageScore)
//                        .thenComparing(LeagueDAO::getStrikeRate)
//                        .thenComparing(LeagueDAO::getNoOfRuns).reversed();
//                break;
//            case "BOWLING_AVG":
//                comparator = Comparator.comparing(LeagueDAO::getBowlingAverageScore).reversed();
//                break;
//            case "BOWLING_Strike_RATES":
//                comparator = Comparator.comparing(LeagueDAO::getBowlingAverageScore).reversed();
//                break;
//            case "BOWLING_ECO":
//                comparator = Comparator.comparing(LeagueDAO::getEconomy).reversed();
//                break;
//            case "BOWLING_SR_4W_5W":
//                comparator = Comparator.comparing(LeagueDAO::getStrikeRate)
//                        .thenComparing(LeagueDAO::getFoursWkts)
//                        .thenComparing(LeagueDAO::getFiveWkts).reversed();
//                break;
//            case "BOWLING_SR_AVG":
//                comparator = Comparator.comparing(LeagueDAO::getStrikeRate)
//                        .thenComparing(LeagueDAO::getBowlingAverageScore).reversed();
//                break;
//            case "BOWLING_WKTS_AVG":
//                comparator = Comparator.comparing(LeagueDAO::getNoOfRuns).thenComparing(LeagueDAO::getBowlingAverageScore).reversed();
//                break;
//            case "SIX_AVG":
//                comparator = Comparator.comparing(LeagueDAO::getaverageScore).thenComparing(LeagueDAO::getNoOfHundreds).reversed();
//                break;
//        }
//        leagueList = new ArrayList<>(leagueDAOMap.values());
//        leagueList.sort(comparator);
//        return new Gson().toJson(leagueList);
//    }
//
//    public static String sortedData(Map<String, LeagueDAO> leagueDAOMap, String parameter) {
//        switch (parameter) {
//            case "AVG_BATTING_BOWLING":
//                comparator = Comparator.comparing(LeagueDAO::getNoOfRuns)
//                        .thenComparing(LeagueDAO::getBowlingAverageScore).reversed();
//                break;
//            case "ALL_ROUNDER":
//                comparator = Comparator.comparing(LeagueDAO::getNoOfRuns)
//                        .thenComparing(LeagueDAO::getNoOfWickets).reversed();
//                break;
//            case "AVG":
//                comparator = Comparator.comparing(LeagueDAO::getBowlingAverageScore)
//                        .thenComparing(LeagueDAO::getaverageScore).reversed();
//                break;
//        }
//        leagueList = new ArrayList<>(leagueDAOMap.values());
//        leagueList.sort(comparator);
//        return new Gson().toJson(leagueList);
//    }
//}
//
