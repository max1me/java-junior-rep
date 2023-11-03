package edu.itmo.project.lesson1516;

public class Fruit {
    private final FruitType type;
    private double price;
    private int count;

    public Fruit(FruitType type, double price, int count) {
        this.type = type;
        this.price = price;
        this.count = count;
    }

    public FruitType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public boolean equals(Fruit fruit) {
        if (this.type == fruit.getType() && this.price == fruit.getPrice()) return true;
        return false;
    }


    public enum FruitType {
        APPLE, PEAR, BANANA, APRICOT
    }
}
