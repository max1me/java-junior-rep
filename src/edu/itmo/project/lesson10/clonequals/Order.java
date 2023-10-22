package edu.itmo.project.lesson10.clonequals;

import java.util.Arrays;

public class Order {
    private final Item[] items;

    public Order(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Arrays.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }

    @Override
    public Order clone() {
        Item[] itemsCopy = new Item[items.length];
        for (int i = 0; i < items.length;i++) {
            itemsCopy[i] = items[i].clone();
        }
        Order o = new Order(itemsCopy);
        return null;
    }
}
