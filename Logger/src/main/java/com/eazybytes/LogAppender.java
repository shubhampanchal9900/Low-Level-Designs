package com.eazybytes;

public interface LogAppender {

    void append(LogMessage message);

    LogLevel getLoglevel();
}
