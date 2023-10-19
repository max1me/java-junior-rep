package edu.itmo.project.lesson08;

public class Bike extends Vehicle {
    private int wheels = 2;
    private String type = "Городской";

    public Bike() {
        super("275");
    }
    public int getWheels() {
        return wheels;
    }

    public Bike(String number){
        super(number);
    }
    public Bike(String number, int maxSpeed) {
        super(number, maxSpeed);
    }

    public void setType(String type) {
        this.type = type;
    }
}
