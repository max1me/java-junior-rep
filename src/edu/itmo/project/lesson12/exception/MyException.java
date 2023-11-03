package edu.itmo.project.lesson12.exception;

public class MyException extends Exception{
    public MyException(Exception e) {
        super(e);
    }
}
