package edu.itmo.project.lesson12.record;

import java.time.LocalDateTime;

public record Review(long id, String text, LocalDateTime createdAt) {
    /*public Review(long id, String text, LocalDateTime createdAt) {

    }*/
    public Review {
        if (id < 0 || text.trim().length() < 5 || createdAt == null)
            throw new IllegalArgumentException("Переданы невалидные параметры");
    }

    public Review(long id, String text) {
        this(id, text, null);
    }
}
