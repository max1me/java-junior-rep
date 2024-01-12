package com.lessons.maven.jpa;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_users")
public class User {
    @Id
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
}
