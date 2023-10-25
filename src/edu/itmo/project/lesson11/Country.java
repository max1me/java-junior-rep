package edu.itmo.project.lesson11;

public enum Country {
    FRANCE("Франция", 123) {
        @Override
        public void sout() {
            System.out.println("реализация FRANCE");
        }
    }, RUSSIA("Россия", 9999) {
        @Override
        public void sout() {}
    }, ITALY("Италия", 956) {
        @Override
        public void sout() {}
    };
    private String name;
    private long population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    Country(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
    public abstract void sout();
}
