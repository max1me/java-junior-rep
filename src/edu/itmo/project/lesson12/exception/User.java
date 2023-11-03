package edu.itmo.project.lesson12.exception;

public class User {
    private int age;

    public User() {

    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
