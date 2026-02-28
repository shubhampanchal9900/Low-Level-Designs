public enum LogLevel{
    DEBUG(0), INFO(1), WARN(2), ERROR(3);

    private final int priority;

    LogLevel(int priority){
        this.priority=priority;
    }

    public boolean isLoggable(LogLevel setLevel){
        return this.priority >= setLevel.priority;
    }

}