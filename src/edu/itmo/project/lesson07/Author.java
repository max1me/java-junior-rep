package edu.itmo.project.lesson07;

public class Author {
    public long id;
    public String name;

    public Author(long authorId) {
        this.id = authorId;
    }

    public Author(long authorId, String authorName){
        this(authorId);
        //this.id = authorId;
        this.name = authorName;
    }

    public String getName() {
        return name;
    }

    public void printInfo(){
        System.out.println("Author: id = " + id + " name = " + name);
    }
    public String getInfo(){
        return "Author: id = " + id + " name = " + name;
    }

    public void getInfo(String prefix){
        if (prefix == null) return;
        System.out.println("Author: id = " + id + " name = " + name);
    }
}
