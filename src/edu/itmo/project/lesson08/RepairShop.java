package edu.itmo.project.lesson08;

public class RepairShop {
    private int maxCapacity = 5;
    private Vehicle[] vehicles = new Vehicle[maxCapacity];
    private String[] colors = {"красный", "жёлтый", "оранжевый", "чёрный"};

    public void addToVehicles(Vehicle vehicle) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                return;
            }
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void repairAll() {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                vehicles[i].repair();
                if (vehicles[i] instanceof Car) {
                    ((Car) vehicles[i]).setColor(colors[(int) (Math.random() * colors.length)]);
                }
                vehicles[i] = null;
            }
        }

        /*for (Vehicle vehicle : vehicles) {
            vehicle.repair();
            if (vehicle instanceof Train) {
                Train t = (Train) vehicle;
                t.changeClimate();
            }
            if (vehicle instanceof Train t) {
                t.changeClimate();
            }
        }*/
    }
}
