package edu.itmo.project.lesson08;

public class Scooter extends Bike {
    private boolean isElectric;
    private int wheels = 2;
    private String type = "Городской";

    public Scooter(String number, int maxSpeed, boolean isElectric){
        super(number);
        this.maxSpeed = maxSpeed;
        this.isElectric = isElectric;
    }
    @Override
    public void repair() {
        if (isElectric) {
            if (damage > 2) {
                damage -= 2;
            } else damage = 0;
        } else if (damage > 3) {
            damage -= 3;
        } else damage = 0;
    }

}
