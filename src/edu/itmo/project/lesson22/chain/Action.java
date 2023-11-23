package edu.itmo.project.lesson22.chain;

public abstract class Action {
    private Action nextAction;

    public Action() {}
    void nextAction(Action action) {
        if (action != null) this.nextAction = action;
    }
    public void action() {
        doSomething();
        if (nextAction != null) nextAction.doSomething();
    };
    protected abstract void doSomething();
}
