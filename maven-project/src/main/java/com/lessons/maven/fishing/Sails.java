package com.lessons.maven.fishing;

import jakarta.persistence.*;

import java.time.LocalDate;

/*Рейсы*/
@Entity
@Table(name = "tb_sails")
public class Sails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "out_date", nullable = false)
    private LocalDate outDate;
    @Column(name = "in_date")
    LocalDate inDate;
    @OneToOne(optional = false)
    @JoinColumn(name = "ship_id", foreignKey = @ForeignKey(name = "fk_sails_ships"))
    private Ships ship;
    /*@OneToOne(optional = false)
    @JoinColumn(name = "crew_id", foreignKey = @ForeignKey(name = "fk_sails_crews"))
    private Crews crew;*/

    public Sails() {
    }

    public Sails(LocalDate outDate, Ships ship) {
        this.outDate = outDate;
        this.ship = ship;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }
}
