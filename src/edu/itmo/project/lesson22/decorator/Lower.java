package edu.itmo.project.lesson22.decorator;

public class Lower extends Decorator {
    public Lower(AppLogger appLogger) {
        super(appLogger);
    }

    @Override
    public void log(String s) {
        if (s == null) throw new IllegalArgumentException("Строка не может быть пустой");
        this.appLogger.log(s.toLowerCase());
    }
}
