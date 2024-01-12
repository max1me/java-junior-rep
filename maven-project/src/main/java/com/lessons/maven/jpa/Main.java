package com.lessons.maven.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lesson36");
        EntityManager manager = factory.createEntityManager();
        Product product = new Product("title", "description", Product.Category.SPORT);

        manager.getTransaction().begin();
        manager.persist(product);
        manager.getTransaction().commit();
        manager.detach(product);
    }
}
