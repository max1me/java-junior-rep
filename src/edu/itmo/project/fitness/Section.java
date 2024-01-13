package edu.itmo.project.fitness;

public enum Section {
    POOL("бассейн"), GYM("тренажерный зал"), GROUP("групповые занятия");
    private String sectionName;
    Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }
}
