package edu.itmo.project.lesson22.chain;

public class Chain {
    public static void main(String[] args) {
        Action action01 = new Eat();
        Action action02 = new Drink();
        Action action03 = new Play();

        // выстраиваются в цепочку
        action01.nextAction(action02);
        action02.nextAction(action03);

        Animal animal = new Animal();
        animal.doAction(action01);
    }
}
