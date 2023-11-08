package edu.itmo.project.lesson1516;

import java.util.Objects;

public class Fruit {
    private final FruitType type;
    private double price;
    private int count;

    public Fruit(FruitType type, double price, int count) {
        Objects.requireNonNull(type);
        if (price <= 0 || count <= 0) throw new IllegalArgumentException("цена и количество должны быть больше 0");
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

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type=" + type +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public enum FruitType {
        APPLE, PEAR, BANANA, APRICOT
    }
}
