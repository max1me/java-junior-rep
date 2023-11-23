package edu.itmo.project.lesson22.strategy;

public class Unit {
    private IAction action;

    public Unit(IAction action) {
        if (action == null) throw new IllegalArgumentException("Неверная стратегия");
        this.action = action;
    }

    public void changeAction(IAction action){
        if (action != null) this.action = action;
    }

    public void move() {

    }
}
