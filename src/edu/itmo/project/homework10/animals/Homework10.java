package edu.itmo.project.homework10.animals;


public class Homework10 {
    public static void main(String[] args) {
        Wolf wolf01 = new Wolf(new String[] {"apple", "orange", ""}, "gray");
        Wolf wolf02 = new Wolf(new String[] {"apple", "orange"}, "gray");

        System.out.println(wolf01.equals(wolf02));
    }
}
