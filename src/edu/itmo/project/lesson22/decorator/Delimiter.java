package edu.itmo.project.lesson22.decorator;

public class Delimiter extends Decorator {
    public Delimiter(AppLogger appLogger) {
        super(appLogger);
    }

    @Override
    public void log(String s) {
        if (s == null) throw new IllegalArgumentException("Строка не может быть пустой");
        this.appLogger.log(s + "\n_\n");
    }
}
