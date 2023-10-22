package edu.itmo.project.homework10.animals;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal{
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wolf wolf = (Wolf) o;
        //Т.к. у нас сравнивается массив строк, то так делать можно
        if (!Arrays.equals(likeToEat, wolf.likeToEat)) return false;
        return Objects.equals(color, wolf.color);
    }
}
