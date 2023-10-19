package edu.itmo.project.lesson08;

import java.util.Arrays;

public class Lesson08 {
    public static void main(String[] args) {
        Bike bike01 = new Bike("123", 20);

        bike01.incDamage(3);
        bike01.repair();

        Train train01 = new Train(25, true, 120, "qwerty");

        train01.incDamage(3);
        train01.repair();

        Vehicle vehicle = new Bike("ffff", 30);
        //Train train02 = (Train) vehicle;
        Bike bike02 = (Bike) vehicle;
        Car car = new Car("123548");
        Scooter scooter = new Scooter("987", 10, false);

        RepairShop repairShop = new RepairShop();

        repairShop.addToVehicles(bike01);
        repairShop.addToVehicles(train01);
        repairShop.addToVehicles(car);
        repairShop.addToVehicles(scooter);

        System.out.println(Arrays.toString(repairShop.getVehicles()));
    }
}
