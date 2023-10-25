package edu.itmo.project.homework11;

public enum Planet {
    MERCURY("Меркурий", 3.3011E23, 2439.7f),
    VENUS("Венера", 4.8675E24, 6051.8f),
    EARTH("Земля", 5.972168E24, 6371f),
    MARS("Марс", 	6.4171E23, 3389.5f),
    JUPITER("Юпитер", 1.8982E27, 69911f),
    SATURN("Сатурн", 5.6834E26, 58232f),
    URANUS("Уран", 8.6810E25, 25362f),
    NEPTUNE("Нептун", 1.02413E26, 24622);
    private String name;
    private double mass;
    private float radius;
    Planet(String name, double mass, float radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}