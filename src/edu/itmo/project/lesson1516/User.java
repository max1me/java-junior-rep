package edu.itmo.project.lesson1516;

import java.time.LocalDate;
import java.util.Comparator;

public class User implements Comparable<User> {
    private String name;
    private LocalDate birth;
    private int salary;

    @Override
    public int compareTo(User o) {


        return 0;
    }

    public static class NameComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static class SalaryComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return o1.salary - o2.salary;
        }
    }
}
