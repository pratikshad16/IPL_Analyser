package com.bridegelabz.ipl_analyser;


import com.bridgelabz.ipl_analyser.LeagueAnalyser;
import com.bridgelabz.ipl_analyser.LeagueAnalyserException;
import org.junit.Assert;
import org.junit.Test;


public class LeagueAnalyserTest {
    private final String RUNS_SHEET = ".\\src\\test\\resources\\IPL2019FactsheetMostRuns.CSV";
    @Test
    public void giv() throws LeagueAnalyserException {
        LeagueAnalyser leagueAnalyser = new LeagueAnalyser();
        int records = leagueAnalyser.loadData(LeagueAnalyser.Player.RUNS, RUNS_SHEET);
        Assert.assertEquals(100, records);
    }
}

