package com.bridegelabz.ipl_analyser;
import com.bridgelabz.ipl_analyser.LeagueAnalyser;
import com.bridgelabz.ipl_analyser.LeagueAnalyserException;
import com.bridgelabz.ipl_analyser.LeagueRunsCSV;
import com.bridgelabz.ipl_analyser.LeagueWktsCSV;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class LeagueAnalyserTest {
    private final String RUNS_SHEET = ".\\src\\test\\resources\\IPL2019FactsheetMostRuns.CSV";
    private final String WKTS_SHEET = ".\\src\\test\\resources\\IPL2019FactsheetMostWkts.CSV";

    @Test
    public void givenRunsFile_whenCheckRecords_shouldReturnCorrectRecords() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            int records = leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            Assert.assertEquals(100, records);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenWktsFile_whenCheckRecords_shouldReturnCorrectRecords() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            int records = leagueAnalyser.loadData(LeagueAnalyser.Player.WKTS, WKTS_SHEET);
            Assert.assertEquals(99, records);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_whenSortWithRespectToAverage_ReturnHighestBattingAvg() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            String sortedData = leagueAnalyser.sortData("AVG");
            LeagueRunsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueRunsCSV[].class);
            Assert.assertEquals("Ben Cutting", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_whenSortWithRespectToStrikeRate_ReturnHighestStrikeRate() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            String sortedData = leagueAnalyser.sortData("STRIKE_RATE");
            LeagueRunsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueRunsCSV[].class);
            Assert.assertEquals("Kedar Jadhav", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_whenSortWithRespectToSixAndFour_ReturnHighestPlayerName() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            String sortedData = leagueAnalyser.sortData("SIX_FOUR");
            LeagueRunsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueRunsCSV[].class);
            Assert.assertEquals("Andre Russell", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_whenSortWithRespectToSixFourAndStrikeRate_ReturnHighestPlayerName() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            String sortedData = leagueAnalyser.sortData("SIX_FOUR_SR");
            LeagueRunsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueRunsCSV[].class);
            Assert.assertEquals("Stuart Binny", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_whenSortWithRespectAverageAndStrikeRate_ReturnHighestPlayerName() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            String sortedData = leagueAnalyser.sortData("AVG_STRIKE_RATE");
            LeagueRunsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueRunsCSV[].class);
            Assert.assertEquals("Shakib Al Hasan", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_SortWithRespectAverageAndRuns_ReturnHighestPlayerName() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
            String sortedData = leagueAnalyser.sortData("RUN_AVG");
            LeagueRunsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueRunsCSV[].class);
            Assert.assertEquals("Shakib Al Hasan", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_SortWithRespectBowlingAverage_ReturnHighestPlayerName() {
        try {
        LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
        leagueAnalyser.loadData(LeagueAnalyser.Player.WKTS, WKTS_SHEET);
        String sortedData = leagueAnalyser.sortData("BOWLING_AVG");
        LeagueWktsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueWktsCSV[].class);
        Assert.assertEquals("Prasidh Krishna", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }
    @Test
    public void givenFile_SortWithRespectBowlingStrikeRates_ReturnHighestPlayerName() {
        try {
        LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
        leagueAnalyser.loadData(LeagueAnalyser.Player.WKTS, WKTS_SHEET);
        String sortedData = leagueAnalyser.sortData("BOWLING_STRIKE_RATES");
        LeagueWktsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueWktsCSV[].class);
        Assert.assertEquals("Alzarri Joseph", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }
    @Test
    public void givenFile_SortWithRespectBowlerBestEconomy_ReturnHighestPlayerName() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.WKTS, WKTS_SHEET);
            String sortedData = leagueAnalyser.sortData("BOWLING_ECO");
            LeagueWktsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueWktsCSV[].class);
            Assert.assertEquals("Mayank Markande", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }
    @Test
    public void givenFile_SortWithRespectBowlerStrikeRate_ReturnHighestPlayerName() {
        try {
            LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
            leagueAnalyser.loadData(LeagueAnalyser.Player.WKTS, WKTS_SHEET);
            String sortedData = leagueAnalyser.sortData("BOWLING_SR_4W_5W");
            LeagueWktsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueWktsCSV[].class);
            Assert.assertEquals("Lasith Malinga", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }
    @Test
    public void givenFile_SortWithRespectBowlerStrikeRateAndAverage_ReturnHighestPlayerName() {
        try {
        LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
        leagueAnalyser.loadData(LeagueAnalyser.Player.WKTS, WKTS_SHEET);
        String sortedData = leagueAnalyser.sortData("BOWLING_SR_AVG");
        LeagueWktsCSV[] leagueRunsCSVS = new Gson().fromJson(sortedData, LeagueWktsCSV[].class);
        Assert.assertEquals("Prasidh Krishna", leagueRunsCSVS[0].name);
        } catch (LeagueAnalyserException e) {
            Assert.assertEquals(LeagueAnalyserException.ExceptionType.FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM, e.type);
        }
    }
}
