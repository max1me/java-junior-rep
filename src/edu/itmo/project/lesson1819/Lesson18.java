package edu.itmo.project.lesson1819;

import edu.itmo.project.lesson1516.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Lesson18 {

    public static void main(String[] args) {
    Operation plus = (first, second) -> first + second;
    Operation minus = (first, second) -> first - second;
    Operation sub = (first, second) -> first * second;
    Operation div = (first, second) -> {
        if (second != 0) throw new IllegalArgumentException("second != 0");
        return first/second;
    };
    Operation min = (a, b) -> a < b ? a : b;

    Operation operation = plus.addOperation(minus).addOperation(div).addOperation(sub);
        System.out.println(operation.action(12.4, 5.7));

    //printResult(min, 1, 50);
    //System.out.println(plus.action(45, + 54));
    ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(875, -78, 12, 56, 34, -89, 0, 344));
    /*
    @FunctionalInterface
    public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}

        boolean test(T t);
     */
        Predicate<Integer> negative = elem -> elem < 0;
    integers.removeIf(negative);
    //integers.removeIf(integer -> integer == 1000);

    ArrayList<String> files = new ArrayList<>(Arrays.asList("01.txt", "02.json", "03.txt", "04.txt", "05.properties"));
    //files.removeIf(string -> !(string.endsWith(".json") || string.endsWith(".properties")));

    ArrayList<Fruit> fruits = new ArrayList<>();
    fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
    fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
    fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
    fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
    fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
    fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
    fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));
    //fruits.removeIf(fruit -> fruit.getType().equals(Fruit.FruitType.BANANA) && fruit.getPrice() < 100);

    fruits.forEach(fruit -> {if (fruit.getType().equals(Fruit.FruitType.BANANA) || fruit.getType().equals(Fruit.FruitType.APPLE)) System.out.println(fruit.getPrice());});
    fruits.forEach(fruit -> fruit.setPrice(fruit.getPrice() * 2));
    Comparator<Fruit> compareByPrice = (a, b) -> (int) (a.getPrice() - b.getPrice());
    Comparator<Fruit> compareByCount = (a, b) -> a.getCount() - b.getCount();
    fruits.sort(compareByPrice);
    fruits.sort(compareByPrice.thenComparing(compareByPrice));
    //fruits.sort(fruit -> fruit.getCount());

}
    private static void printResult(Operation operation, double a, double b) {
        System.out.println(operation.action(a, b));
    }
    private static ArrayList<? extends Fruit> getFruitList(ArrayList<? extends Fruit> fruits, Predicate filter) {
        fruits.removeIf(filter);
        return fruits;
    }

}
