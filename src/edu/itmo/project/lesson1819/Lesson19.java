package edu.itmo.project.lesson1819;

import edu.itmo.project.lesson14.properties.vehicle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lesson19 {
    public static void main(String[] args) {
        Stream<Integer> values = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        values.distinct()
                .map(integer -> integer < 0 ? 0 : integer)
                .sorted((a, b) -> b - a)
                .forEach(integer -> System.out.println(integer));

        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        System.out.println(Arrays.stream(colors)
                .filter(string -> !string.contains("yellow"))
                .count());
        List<Repaintable> repaintables = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.BLACK, "002"),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new MiniCar(Repaintable.Color.BLUE, "005"),
                new Car(Repaintable.Color.BLACK, "006"),
                new Car(Repaintable.Color.ORANGE, "007")
        );
        List<Repaintable.Color> colorList = repaintables.stream().map(car -> car.getColor()).distinct().toList();

        List<Vehicle> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new Train("002", 10, true),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Bus("004"),
                new Train("005", 15, false),
                new Car(Repaintable.Color.BLACK, "006"),
                new MiniCar(Repaintable.Color.ORANGE, "007")
        );
    }
}
