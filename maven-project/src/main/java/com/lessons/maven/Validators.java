package com.lessons.maven;

import java.util.Objects;

public class Validators {

    public static boolean stringBetween(String s, int min, int max) {
        Objects.requireNonNull(s);
        return s.length() > min && s.length() < max;
    }

    public static boolean isPositive(int a) {
        return a > 0;
    }
}
