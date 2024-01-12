package com.lessons.maven.fishing;

import jakarta.persistence.*;
/*Команда*/
@Entity
@Table(name = "tb_crews")
public class Crews {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "sail_id", foreignKey = @ForeignKey(name = "fk_crews_sail"))
    private Sails sails;
    @Id
    @ManyToOne
    @JoinColumn(name = "worker_id", foreignKey = @ForeignKey(name = "fk_crews_worker"))
    private Workers workers;

    public Crews() {
    }

    public Crews(Sails sails, Workers workers) {
        this.sails = sails;
        this.workers = workers;
    }
}
