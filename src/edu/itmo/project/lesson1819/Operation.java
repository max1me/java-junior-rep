package edu.itmo.project.lesson1819;

@FunctionalInterface
public interface Operation {
    double action(double a, double b);

    default Operation addOperation (Operation other) {

        return (a, b) -> action(a, b) + other.action(a, b);
    }
}
