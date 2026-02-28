package com.eazybytes;

import java.time.LocalDateTime;

public class LogMessage{


    private final LogLevel logLevel;
    private final String message;
    private final LocalDateTime localDateTime;
    private final String threadName;
    private final String className;

    public LogMessage(LogLevel logLevel, String message, String className) {
        this.logLevel = logLevel;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
        this.threadName = Thread.currentThread().getName();
        this.className = className;
    }

    public LogLevel getLogLevel(){
        return logLevel;
    }

    public  String getMessage(){
        return message;
    }
    public  String getThreadName(){
        return threadName;
    }
    public  String getClassName(){
        return className;
    }
    public LocalDateTime getLocalDateTime(){
        return localDateTime;
    }

}