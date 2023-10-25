package edu.itmo.project.lesson11;

import java.util.Arrays;

public class Lesson11 {
    public static void main(String[] args) {
        Country france = Country.FRANCE;
        Article article = new Article(Country.RUSSIA);
        System.out.println(france == article.getCountry());

        Country[] countries = Country.values();
        System.out.println(france.name());
        System.out.println(Arrays.toString(countries));
        System.out.println(Country.ITALY.ordinal());
        System.out.println(france.toString());

        Country.ITALY.setName("Италия");
        Country.FRANCE.setName("Франция");

        System.out.println(france.getName());

    }
}
