package edu.itmo.project.lesson08;

abstract public class Vehicle {
    protected String number;
    protected int damage;
    protected int maxSpeed = 120;
    public Vehicle(String number){
        this.number = number;
    }

    public Vehicle (String number, int maxSpeed) {
        this(number);
        this.maxSpeed = maxSpeed;
    }

    public void incDamage(int damage) {
        if (damage < 0) return;
        this.damage += damage;
    }
    public void repair() {
        if (this.damage > 0) this.damage--;
    }

    public String getNumber() {
        return number;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    //public abstract void stop();
}
