package com.bridgelabz.ipl_analyser;


public class LeagueAnalyserException extends Exception {
    public enum ExceptionType {
        FILE_PROBLEM, NO_DATA,FILE_TYPE_OR_DELIMITER_OR_HEADER_PROBLEM
    }
   public ExceptionType type;
    public LeagueAnalyserException(String message,String name) {
        super(message);
        this.type=ExceptionType.valueOf(name);
    }

    public LeagueAnalyserException(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }

    public LeagueAnalyserException(String message,ExceptionType type,Throwable cause) {
        super(message,cause);
        this.type=type;
    }
}
