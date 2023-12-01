package edu.itmo.project.lesson25;

import java.util.Collections;
import java.util.List;

public class Trader extends UserData {
    private static final long serialVersionUID = 1L;

    //private String name = "name";
    private long id;
    private List<Item> items;
    private Rate rate;
    private boolean isActive;

    public Trader(long id, List<Item> items, Rate rate, String username, String password) {
        super(username, password);
        this.id = id;
        this.items = items;
        this.rate = rate;
        this.isActive = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}