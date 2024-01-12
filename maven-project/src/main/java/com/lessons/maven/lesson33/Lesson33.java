package com.lessons.maven.lesson33;

public class Lesson33 {
    public static final String CONNECTION_STR = "jdbc:postgresql://localhost:5432/db_name";
    public static final String LOGIN = "user";
    public static final String PWD = "p@ssword";

    public static void main(String[] args) {
        AuthorQuery authorQuery = new AuthorQuery();

        authorQuery.createTable();
    }
}
