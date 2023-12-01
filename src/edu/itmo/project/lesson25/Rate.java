package edu.itmo.project.lesson25;

import java.io.Serializable;

public class Rate implements Serializable {
    private int id;
    private RateType rateType;

    public Rate(int id, RateType rateType) {
        this.id = id;
        this.rateType = rateType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public enum RateType{
        FULL, LITE
    }
}