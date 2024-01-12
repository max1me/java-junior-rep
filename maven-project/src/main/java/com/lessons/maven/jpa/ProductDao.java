package com.lessons.maven.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDao {
    private EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> allProducts() {
        TypedQuery<Product> query = entityManager.createNamedQuery("get_all", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    public Product productByTitle(String title) {
        TypedQuery<Product> query = entityManager.createNamedQuery("get_by_title", Product.class);
        query.setParameter("title_param", title);
        Product product = query.getSingleResult();
        return product;
    }
}
