package edu.itmo.project.lesson22.observer;

import java.util.ArrayList;

public class Connection {
    private Status status;
    private ArrayList<Listener> listeners;
    public Connection() {
        listeners = new ArrayList<>();
    }
    public void addListener(Listener listener) {
        if (listener != null && !listeners.contains(listener)) listeners.add(listener);
    }
    public void changeStatus(Status status) {
        this.status = status;
        for (Listener listener:listeners) listener.notifyListener(this.status);
    }
    public enum Status {
        ACTIVE, CLOSE, CONNECTED, WAITING
    }
}
