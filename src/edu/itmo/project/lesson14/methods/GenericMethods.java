package edu.itmo.project.lesson14.methods;

import edu.itmo.project.lesson14.properties.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class GenericMethods {











    //типизированные (generic) методы

    public static  <T> boolean inArray(T[] array, T element) {
        if (array == null || element == null) return false;
        for (T elem : array) {
            if (elem != null && elem.equals(element)) return true;
        }
        return false;
    }
    // generic с ограничением
    public static <T extends Number, K extends Temporal> int compareHashCodes(T first, K second) {
        System.out.println(first.longValue());
        System.out.println(second.plus(3, ChronoUnit.DAYS));
        return Integer.compare(first.hashCode(), second.hashCode());
    }

    public static void main(String[] args) {
        User<String> stringUser = new User<>("125478");
        User<Integer> integerUser = new User<>(125478);

        stringUser.setId("45");
        stringUser.getId();


        User rawUser = new User<>("125478");
        rawUser.setId(12);
        rawUser.setId(stringUser);














        String[] strings = {"red", "blue", "white"};
        String string = "yellow";

        boolean res = GenericMethods.<String>inArray(strings, string);
        System.out.println(res);

        Integer[] integers = {45, 85, 98, 100};
        Integer integer = 85;

        res = GenericMethods.<Number>inArray(integers, integer);
        System.out.println(res);

        int result = GenericMethods.<Number, LocalDate>compareHashCodes(1, LocalDate.now());
    }
}
