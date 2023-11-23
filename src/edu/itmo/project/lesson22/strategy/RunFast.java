package edu.itmo.project.lesson22.strategy;

public class RunFast<T> implements IAction<T>{
    @Override
    public void execute(T unit){
        System.out.println("unit RunFast");
    }
}
