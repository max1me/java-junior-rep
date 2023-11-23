package edu.itmo.project.lesson22.decorator;

public abstract class Decorator implements AppLogger {
    protected AppLogger appLogger;

    public Decorator(AppLogger appLogger) {
        if (appLogger == null) throw new IllegalArgumentException("appLogger не может быть null");
        this.appLogger = appLogger;
    }
    public void log(AppLogger appLogger) {
    }
}
