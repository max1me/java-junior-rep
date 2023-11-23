package edu.itmo.project.lesson22.observer;

public class AppLogger implements Listener<Connection> {
    public AppLogger() {
    }

    @Override
    public void notifyListener(Connection connection) {
        System.out.println("AppLogger");
    }
}
