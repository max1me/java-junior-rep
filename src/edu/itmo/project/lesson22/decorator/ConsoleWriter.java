package edu.itmo.project.lesson22.decorator;

public class ConsoleWriter implements AppLogger {

    @Override
    public void log(String s) {
        if (s != null) System.out.println(s);
    }
}
