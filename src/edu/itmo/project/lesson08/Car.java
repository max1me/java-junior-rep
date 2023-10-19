package edu.itmo.project.lesson08;

public class Car extends Vehicle {
    private String color = "white";

    public Car(String number) {
        super(number);
        this.maxSpeed = 240;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void repair() {
        if (damage > 0) {
            damage--;
        }
    }
}
