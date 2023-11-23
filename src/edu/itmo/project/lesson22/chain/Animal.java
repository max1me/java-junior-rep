package edu.itmo.project.lesson22.chain;

public class Animal {
    public Animal() {
    }
    public void doAction(Action action) {
        action.action();
    }
}
