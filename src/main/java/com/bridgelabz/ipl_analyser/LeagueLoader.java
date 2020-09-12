package com.bridgelabz.ipl_analyser;
import com.bridegelabz.censusanalysersecond.CSVBuilderException;
import com.bridegelabz.censusanalysersecond.CSVBuilderFactory;
import com.bridegelabz.censusanalysersecond.ICSVBuilder;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class LeagueLoader {
    Map map = new HashMap();

    public Map loadLeagueData(String csvfilePath, LeagueAnalyser.Player player) throws LeagueAnalyserException {
        if (player.equals(LeagueAnalyser.Player.RUNS)) {
            return this.loadLeagueData(csvfilePath, LeagueRunsCSV.class);
        } else if (player.equals(LeagueAnalyser.Player.WKTS)) {
            return this.loadLeagueData(csvfilePath, LeagueWktsCSV.class);
        }
        return null;
    }

    public <E> Map loadLeagueData(String csvFilePath, Class<E> LeagueCSV) throws LeagueAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, LeagueCSV);
            Iterable<E> leagueCSVIterable = () -> csvFileIterator;
            if (LeagueCSV.getName().equals("com.bridgelabz.ipl_analyser.LeagueRunsCSV"))
                StreamSupport.stream(leagueCSVIterable.spliterator(), false)
                        .map(LeagueRunsCSV.class::cast)
                        .forEach(csvPlayer -> map.put(csvPlayer.name, new LeagueDAO(csvPlayer)));
            else if (LeagueCSV.getName().equals("com.bridgelabz.ipl_analyser.LeagueWktsCSV")) {
                StreamSupport.stream(leagueCSVIterable.spliterator(), false)
                        .map(LeagueWktsCSV.class::cast)
                        .forEach(csvPlayer -> map.put(csvPlayer.name, new LeagueDAO(csvPlayer)));
            }
            return map;
        } catch (IOException e) {
            throw new LeagueAnalyserException(e.getMessage(), LeagueAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new LeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }
}
