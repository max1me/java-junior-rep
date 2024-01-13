package edu.itmo.project.fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Fitness {
    private Set<SportPass> poolList = new HashSet<>();
    private Set<SportPass> gymList = new HashSet<>();
    private Set<SportPass> groupList = new HashSet<>();

    public Fitness() {

    }
    public void showAbonements() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Посетители тренажерного зала: ");
        for(SportPass pass : gymList) {
            stringBuffer.append(pass.getClient().getInfo());
            stringBuffer.append("\n");
        }
        stringBuffer.append("Посетители бассейна: ");
        for(SportPass pass : poolList) {
            stringBuffer.append(pass.getClient().getInfo());
            stringBuffer.append("\n");
        }
        stringBuffer.append("Посетители групповых занятий: ");
        for(SportPass pass : groupList) {
            stringBuffer.append(pass.getClient().getInfo());
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());
    }

    public Set<SportPass> getListBySection(Section section) {
        return (switch (section) {
            case POOL -> poolList;
            case GYM -> gymList;
            case GROUP -> groupList;
        });
    }

    public boolean addPass(Section section, SportPass pass) {
        if (checkPass(section, pass)) {
            getListBySection(section).add(pass);
            System.out.println("Клиент " + pass.getClient().getInfo() + " зарегистрирован в зоне " + section.getSectionName());
            return true;
        }
        return false;
    }

    public void addPasses(ArrayList<SportPass> sportPasses) {
        Objects.requireNonNull(sportPasses);
        for (SportPass sportPass : sportPasses) {
            addPass(Section.values()[(int)(Math.random() * 2)], sportPass);
        }
    }

    private boolean checkPass(Section section, SportPass pass) {
        int size = 0;
        switch (section) {
            case POOL: size = poolList.size();
            break;
            case GYM: size = gymList.size();
            break;
            case GROUP: size = groupList.size();
        }
        if (size < 20) {
            if (pass.getType().getSections().contains(section)) {
                if (pass.getExpirationDateTime().isAfter(LocalDateTime.now())) {
                    if (checkPassTime(pass.getType())) {
                        return true;
                    } else System.out.println("В это время посещение невозможно, " + pass.getClient().getInfo());
                } else System.out.println("Срок действия абонемента истёк, " + pass.getClient().getInfo());
            } else System.out.println("По данному абонементу невозможен проход в " + section.getSectionName() + ", " + pass.getClient().getInfo() + ", смените тип абонемента");
        } else System.out.println("В зоне " + section.getSectionName() + " нет свободных мест, " + pass.getClient().getInfo() + ", попробуйте позднее");
        return false;
    }
    private boolean checkPassTime(PassType type) {
        return type.getStartHour() <= LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0, 0)).getHour()
                && type.getEndHour() > LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0, 0)).getHour();
        /*return type.getStartHour() <= LocalDateTime.now().getHour() && type.getEndHour() > LocalDateTime.now().getHour();*/
    }



}
