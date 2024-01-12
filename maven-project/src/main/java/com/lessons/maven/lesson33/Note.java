package com.lessons.maven.lesson33;

import java.time.ZonedDateTime;

public class Note {
    private long id;
    private String title;
    private String text;
    private ZonedDateTime createdAt;
    private Author author;

    public Note(long id, String title, String text, ZonedDateTime createdAt, Author author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
