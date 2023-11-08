package edu.itmo.project.lesson1516;

import java.util.*;

public class FruitStorage {
    private int numberOfSlots;
    private ArrayList<Fruit> fruits = new ArrayList<>();

    public FruitStorage(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public boolean addToStorage(Fruit fruit) {
        if (fruit == null /*|| fruits.contains(fruit)*/) {
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

    // вернуть количество фруктов определённого типа
    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        int numberOfFruits = 0;
        for (Fruit fruit:fruits) {
            if (fruit != null && fruitType != null && fruit.getType().equals(fruitType)) {
                numberOfFruits += fruit.getCount();
            }
        }
        return numberOfFruits;
    }

    // вернуть количество свободных мест в хранилище
    public int getNumberOfEmptySlots(){
        return this.numberOfSlots;
    }

    public void increasePrice(int value){
        // value может быть в диапазоне [10; 30)
        // увеличить цену всех фруктов на value процентов
        if (!(value >= 10 && value < 30)) throw new IllegalArgumentException("value может быть в диапазоне [10; 30)");
        for (Fruit fruit:fruits) {
            fruit.setPrice(fruit.getPrice() * (1d + (double)value/100));
        }
    }

    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        List<Fruit> fruitList = new ArrayList<>();
        Objects.requireNonNull(fruitType);
        if (maxPrice <= 0) throw new IllegalArgumentException("maxPrice должна быть положительной");
        // maxPrice должна быть положительной, fruitType не null
        // возвращает список, в который войдут фрукты из коллекции fruits
        // с типом fruitType и ценой не выше maxPrice
        for (Fruit fruit:fruits) {
            if (fruit.getType().equals(fruitType) && fruit.getPrice() < maxPrice) fruitList.add(fruit);
        }
        return fruitList;
    }

    public Set<Fruit.FruitType> getFruitTypes(){
        Set<Fruit.FruitType> fruitTypeSet = new HashSet<>();
        for (Fruit fruit:fruits) {
            fruitTypeSet.add(fruit.getType());
        }
        return fruitTypeSet;
    }

    public double getMinPriceByType(Fruit.FruitType fruitType){
        Objects.requireNonNull(fruitType);
        double minPrice = 0;
        for (Fruit fruit:fruits) {
            if (fruit.getType().equals(fruitType) && (fruit.getPrice() < minPrice || minPrice == 0)) {
                minPrice = fruit.getPrice();
            }
        }
        return minPrice;
    }
}
