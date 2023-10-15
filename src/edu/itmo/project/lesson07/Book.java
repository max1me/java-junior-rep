package edu.itmo.project.lesson07;

public class Book {
    private String name;
    private boolean isPublished;
    private Author[] authors;

    public Book(){}

    public Book(String name, int numberOfAuthors) {
        setName(name);
        if (numberOfAuthors >= 1 && numberOfAuthors < 5) {
            authors = new Author[numberOfAuthors];
        } else throw new IllegalArgumentException("Недопустимое количество");
    }
    public String getName() {
        return name;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name not null");
        }
        this.name = name;
    }

    public void addAddAuthor(Author author){
        if (author != null) {
            boolean isAuthorAdded;
            for (int i = 0; i < authors.length; i++) {
                isAuthorAdded = authors[i] == author;
                if (isAuthorAdded) break;
                if (authors[i] == null && !isAuthorAdded) {
                    authors[i] = author;
                    System.out.println("Автор " + author.getName() +  " добавлен");
                    break;
                }
            }
        } else throw new IllegalArgumentException("Автор должен быть указан");
    }
}
