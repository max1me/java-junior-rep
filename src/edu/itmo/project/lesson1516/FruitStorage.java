package edu.itmo.project.lesson1516;

import java.util.ArrayList;

public class FruitStorage {
    private int numberOfSlots;
    private ArrayList<Fruit> fruits;

    public FruitStorage(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public boolean addToStorage(Fruit fruit) {
        if (fruit == null || fruits.contains(fruit) || fruits.size() == numberOfSlots) {
            return false;
        } else {
            for (int i = 0; i < fruits.size(); i++) {
                Fruit fruitFromCollection = fruits.get(i);
                if (fruitFromCollection.equals(fruit)) {
                    if (numberOfSlots - fruit.getCount() < 0) return false;
                    fruitFromCollection.setCount(fruitFromCollection.getCount() + fruit.getCount());
                    numberOfSlots -= fruit.getCount();
                    return true;
                }
            }
            if (numberOfSlots - fruit.getCount() < 0) return false;
            fruits.add(fruit);
            numberOfSlots -= fruit.getCount();
            return true;
        }
    }
}
