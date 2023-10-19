package edu.itmo.project.lesson08;

public class Train extends Vehicle {
    private int numberOfCars;
    private boolean isclimateControl;
    public Train(int numberOfCars, boolean climateControl, int maxSpeed, String number) {
        super(number, maxSpeed);
        this.numberOfCars = numberOfCars;
        this.isclimateControl = climateControl;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public boolean isIsclimateControl() {
        return isclimateControl;
    }

    public void changeClimate() {
        this.isclimateControl = !isclimateControl;
    }

    @Override
    public void repair() {
        if (numberOfCars < 7 && numberOfCars > 0) {
            if (damage >= 2) damage -= 2;
            else damage--;
        } else super.repair();
    }

    /*@Override
    public void stop() {

    }*/
}
