package edu.itmo.project.lesson22.decorator;

public class Upper extends Decorator {
    public Upper(AppLogger appLogger) {
        super(appLogger);
    }

    @Override
    public void log(String s) {
        if (s == null) throw new IllegalArgumentException("Строка не может быть пустой");
        this.appLogger.log(s.toUpperCase());
    }
}
