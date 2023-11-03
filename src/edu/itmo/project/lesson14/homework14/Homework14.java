package edu.itmo.project.lesson14.homework14;

import edu.itmo.project.lesson14.properties.User;

public class Homework14 {
    public static void main(String[] args) {
        String string = "abc";
        Byte num01 = 1;
        Short num02 = 1;
        Integer num03 = 1;
        Double num04 = 1.0d;
        /*Создать экземпляр PairContainer, где key - любые числа, value - строка*/
        PairContainer<? extends Number, String> pairContainer01;
        pairContainer01 = new PairContainer<>(num01, string);
        pairContainer01 = new PairContainer<>(num02, string);
        pairContainer01 = new PairContainer<>(num03, string);
        pairContainer01 = new PairContainer<>(num04, string);

        /*Создать экземпляр PairContainer, где key - строка, value - тип User, у которого id - любые числа*/
        PairContainer<String, User<? extends Number>> pairContainer02;
        pairContainer02 = new PairContainer<>(string, new User<>(num01));
        pairContainer02 = new PairContainer<>(string, new User<>(num02));
        pairContainer02 = new PairContainer<>(string, new User<>(num03));
        pairContainer02 = new PairContainer<>(string, new User<>(num04));
        /*Создать экземпляр PairContainer, где key - строка, value - тип PairContainer, у которого key - любые числа,
        value - тип User, у которого id - строка*/
        PairContainer<String, PairContainer<? extends Number, User<String>>> pairContainer03;
        pairContainer03 = new PairContainer<>(string, new PairContainer<>(num01, new User<>(string)));
        pairContainer03 = new PairContainer<>(string, new PairContainer<>(num02, new User<>(string)));
        pairContainer03 = new PairContainer<>(string, new PairContainer<>(num03, new User<>(string)));
        pairContainer03 = new PairContainer<>(string, new PairContainer<>(num04, new User<>(string)));

    }
}
