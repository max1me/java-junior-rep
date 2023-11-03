package edu.itmo.project.lesson1516;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
/*        LinkedList<String> strings01 = new LinkedList<>();
        List<String> strings02;

        System.out.println(strings01.size());
        strings01.add("Тверь");
        strings01.add("Москва");
        strings01.add("СПб");
        strings01.add("Самара");
        strings01.add(null);

        strings02 = Arrays.asList("Саратов", "Новгород");

        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.size());
        integers.add(3);
        integers.add(6);
        integers.add(67);
        integers.add(67);
        integers.add(67);
        integers.add(67);

        for (var integer : integers) {
            System.out.println(integer);
        }
        for (int i = 0; i < strings02.size(); i++) {
            System.out.println(strings01.element());
        }

        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
            if (element == 67) {
                integers.remove(element);
            }
        }
        integers.removeIf(integer -> integer == 67);*/

        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(4);
        integerHashSet.add(6);
        integerHashSet.add(4);
        integerHashSet.add(47);
        integerHashSet.add(70);
        integerHashSet.add(145);

        System.out.println(integerHashSet);

        Comparator<User> byName = new User.NameComparator();
        Comparator<User> bySalary = new User.SalaryComparator();
        Comparator<User> byNameThenBySalary = byName.thenComparing(bySalary);

        TreeSet<User> users01 = new TreeSet<>(byNameThenBySalary);
        TreeSet<User> users02 = new TreeSet<>(byName);
    }
}
