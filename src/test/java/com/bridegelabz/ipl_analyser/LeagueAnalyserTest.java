package com.bridegelabz.ipl_analyser;
import com.bridgelabz.ipl_analyser.LeagueAnalyser;
import com.bridgelabz.ipl_analyser.LeagueAnalyserException;
import com.bridgelabz.ipl_analyser.LeagueRunsCSV;
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
    public void givenFile_whwnSortWithRespectToSixAndFour_ReturnHighestPlayerName() {
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
}

