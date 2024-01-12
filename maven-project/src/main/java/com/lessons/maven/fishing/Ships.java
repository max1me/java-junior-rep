package com.lessons.maven.fishing;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Table(name = "tb_ships",
        uniqueConstraints = @UniqueConstraint(name = "uk_ships", columnNames = {"name", "type", "manufactured_date"}))
public class Ships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    @Check(name = "tb_ships_check_displacement", constraints = "displacement > 0")
    private double displacement;
    @Column(name = "manufactured_date", nullable = false)
    private LocalDate manufacturedDate;

    public Ships() {
    }

    public Ships(String name, String type, double displacement, LocalDate manufacturedDate) {
        this.name = name;
        this.type = type;
        this.displacement = displacement;
        this.manufacturedDate = manufacturedDate;
    }
}
