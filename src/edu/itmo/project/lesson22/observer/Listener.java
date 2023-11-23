package edu.itmo.project.lesson22.observer;

public interface Listener<T> {
    void notifyListener(T t);
}
