package edu.itmo.project.lesson22.strategy;

interface IAction<T> {
    /*void move();
    void changeAction();*/
    void execute (T t);
}
