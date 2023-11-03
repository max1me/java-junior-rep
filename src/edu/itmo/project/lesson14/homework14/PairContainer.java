package edu.itmo.project.lesson14.homework14;

public class PairContainer <T, K> {
    private T key;
    private K value;

    public PairContainer(T key, K value) {
        this.key = key;
        this.value = value;
    }
}
