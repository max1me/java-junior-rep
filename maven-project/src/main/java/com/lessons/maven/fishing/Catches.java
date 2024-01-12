package com.lessons.maven.fishing;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

/*Улов*/
@Entity
@Table(name = "tb_catches")
public class Catches {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "sail_id", foreignKey = @ForeignKey(name = "fk_catches_sail"))
    private Sails sails;
    @Id
    @Column(name = "fish_type", nullable = false)
    private String fishType;
    @Column(nullable = false)
    @Check(name = "tb_catches_check_mass", constraints = "mass > 0")
    private double mass;

    public Catches() {
    }

    public Catches(Sails sails, String fishType, double mass) {
        this.sails = sails;
        this.fishType = fishType;
        this.mass = mass;
    }
}
