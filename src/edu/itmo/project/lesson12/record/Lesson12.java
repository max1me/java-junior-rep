package edu.itmo.project.lesson12.record;

import java.time.LocalDateTime;

public class Lesson12 {
    public static void main(String[] args) {
        Review review = new Review(1, "qwerty", LocalDateTime.now());
        Review review2 = new Review(2, "qqqqqqqqqq", LocalDateTime.now());

        System.out.println(review.text() + " " + review.id() + " " + review.createdAt().toString());
    }
}
