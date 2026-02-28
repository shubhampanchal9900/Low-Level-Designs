package com.eazybytes;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Logger {

    private static volatile Logger instance;

    private  List<LogAppender> appenders;


    // Private constructor to prevent instantiation
    Logger() {
        this.appenders = new CopyOnWriteArrayList<>();
    }


    // Double-checked locking
    public static Logger getInstance() {
        if (instance == null) {                    // First check (no locking)
            synchronized (Logger.class) {
                if (instance == null) {            // Second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Add appender (Console, File, DB, whatever)
    public void addAppender(LogAppender appender) {
        if (appender == null) {
            throw new IllegalArgumentException("Appender cannot be null");
        }
        appenders.add(appender);
    }

    // Core logging method
    public void log(LogLevel level, String message, String className) {


        LogMessage logMessage = new LogMessage(level, message, className);

        for (LogAppender appender : appenders) {
            if (level.isLoggable(appender.getLoglevel())) {
                appender.append(logMessage);
            }
        }
    }
}
