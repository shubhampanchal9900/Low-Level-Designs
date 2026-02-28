package com.eazybytes;


public class ConsoleAppender implements LogAppender{

    private LogLevel logLevel;
    private LogFormatter formatter;

    ConsoleAppender(LogLevel logLevel,LogFormatter formatter){
        this.logLevel=logLevel;
        this.formatter=formatter;
    }
    @Override
    public void append(LogMessage message) {
        if(message.getLogLevel().isLoggable(logLevel)){
            System.out.println(formatter.formattedMessage(message));
        }
    }

    @Override
    public LogLevel getLoglevel() {
        return logLevel;
    }

}
