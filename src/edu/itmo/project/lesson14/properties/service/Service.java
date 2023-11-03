package edu.itmo.project.lesson14.properties.service;

public class Service<T> {
    private T element;

    public Service() {
    }

    public Service(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void startRepair(){
        System.out.println(element);
    }
}
