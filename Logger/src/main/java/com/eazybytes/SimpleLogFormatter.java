package com.eazybytes;

import java.time.format.DateTimeFormatter;

public class SimpleLogFormatter implements LogFormatter{
    @Override
    public String formattedMessage(LogMessage message) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        return "[" + formatter.format(message.getLocalDateTime()) + "]" +
                " [" + message.getLogLevel() + "]" +
                " [" + message.getThreadName() + "]" +
                " [" +  message.getClassName() + "] - " + message.getMessage();



    }
}
