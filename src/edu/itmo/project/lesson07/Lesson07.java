package edu.itmo.project.lesson07;

public class Lesson07 {
    public static void main(String[] args) {
        Author author = new Author(567, "Вася");
        Author author02 = new Author(123, "John");
        Author author03 = new Author(423, "Alex");
        Author author04 = new Author(423, "Matt");
        Book book = new Book();
        System.out.println(author.id);
        author.id = 1;
        author.printInfo();
        String info = author.getInfo();
        author.getInfo(null);
        author02.getInfo("d");

        book.setName("Java");

        Book book02 = new Book("123456", 3);

        book02.addAddAuthor(author);
        book02.addAddAuthor(author02);
        book02.addAddAuthor(author02);
        book02.addAddAuthor(author02);
        book02.addAddAuthor(author03);
        book02.addAddAuthor(author03);
        book02.addAddAuthor(author04);

        Cat cat01 = new Cat(2);
        Cat cat02 = new Cat(3);
        System.out.println(cat01.attack(cat02) + " " + cat01.getVictories() + " " + cat02.getVictories());
        cat01.setWeigth(4);
        System.out.println(cat01.attack(cat02) + " " + cat01.getVictories() + " " + cat02.getVictories());
    }
}
