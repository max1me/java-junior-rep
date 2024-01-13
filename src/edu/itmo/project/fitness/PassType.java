package edu.itmo.project.fitness;

import java.util.HashSet;
import java.util.Set;

public enum PassType {
    SINGLE(8, 22), DAYTIME(8, 16), UNLIM(8, 22);
    private int startHour;
    private int endHour;
    private Set<Section> sections = new HashSet<>();

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public Set<Section> getSections() {
        return sections;
    }

    PassType(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
        sections.add(Section.GYM);
        if (this.name().equals("UNLIM") || this.name().equals("SINGLE")) {
            sections.add(Section.POOL);
        }
        if (this.name().equals("UNLIM") || this.name().equals("DAYTIME")) {
            sections.add(Section.GROUP);
        }
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Тип абонемента: " + this.name());
        stringBuffer.append("\n");
        stringBuffer.append("Время начала прохода: " + getStartHour());
        stringBuffer.append("\n");
        stringBuffer.append("Время окончания прохода: " + getEndHour());
        stringBuffer.append("\n");
        stringBuffer.append("Доступные зоны: " + getSections().toString());
        return stringBuffer.toString();
    }
}
