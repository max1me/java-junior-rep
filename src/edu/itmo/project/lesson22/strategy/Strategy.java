package edu.itmo.project.lesson22.strategy;

public class Strategy {
    IAction<Unit> run = new Run();
    IAction<Unit> runFast = new RunFast();
    IAction<Unit> walk = new Walk();


}
