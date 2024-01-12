package com.lessons.maven.fishing;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_workers")
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String post;

    public Workers() {
    }

    public Workers(String name, String address, String post) {
        this.name = name;
        this.address = address;
        this.post = post;
    }
}
