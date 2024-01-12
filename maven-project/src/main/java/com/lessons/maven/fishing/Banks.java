package com.lessons.maven.fishing;

import jakarta.persistence.*;

import java.time.LocalDate;

/*Банка*/
@Entity
@Table(name = "tb_banks")
public class Banks {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "sail_id", foreignKey = @ForeignKey(name = "fk_banks_sail"))
    private Sails sails;
    @Id
    @Column
    private String name;
    @Column(name = "fish_quality")
    private String fishQuality;
    @Id
    @Column(name = "in_date")
    LocalDate inDate;
    @Column(name = "out_date")
    private LocalDate outDate;

    public Banks() {
    }

    public Banks(Sails sails, String name, LocalDate inDate) {
        this.sails = sails;
        this.name = name;
        this.inDate = inDate;
    }

    public Banks(Sails sails, String name, String fishQuality, LocalDate inDate, LocalDate outDate) {
        this.sails = sails;
        this.name = name;
        this.fishQuality = fishQuality;
        this.inDate = inDate;
        this.outDate = outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public void setFishQuality(String fishQuality) {
        this.fishQuality = fishQuality;
    }
}
