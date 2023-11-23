package edu.itmo.project.lesson20.task;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, List<Student>> studentsByGender = students.stream()
                .collect(Collectors.groupingBy(student -> student.getGender()));
        //System.out.println(studentsByGender.toString());
        //  2. Найти средний возраст учеников
        double averageAge = students.stream().collect(Collectors.summarizingInt(student -> Period.between(student.getBirth(), LocalDate.now()).getYears())).getAverage();
        //System.out.println(averageAge);
        //  3. Найти самого младшего ученика - Stream -> min(Comparator<Student>): int compare(T o1, T o2);
//        Student student01 = students.stream().min((a, b) -> Period.between(a.getBirth(), LocalDate.now()).getDays() - Period.between(b.getBirth(), LocalDate.now()).getDays()).get();
//        Student student01 = students.stream().min((a, b) -> Period.between(a.getBirth(), LocalDate.now()).getDays() - Period.between(b.getBirth(), LocalDate.now()).getDays()).get();
       // System.out.println(student01.toString());
        Comparator<Student> birth = (s1, s2) -> s2.getBirth().compareTo(s1.getBirth());
        Optional<Student> student01 = students.stream().min(birth);
        System.out.println(student01.toString());

        //  5. Собрать учеников в группы по году рождения, результат - Map<Integer, List<Student>>

        //  6. Отсортировать по полу, дате рождения, имени (в обратном порядке), собрать в список (ArrayList)
        Comparator<Student> studentComparator = Comparator.<Student>comparingInt(student->student.getGender().ordinal())
                .thenComparing(student -> student.getBirth())
                .thenComparing(student -> student.getName()).reversed();
        ArrayList<Student> studentSortedArrayList = students.stream().sorted(studentComparator).collect(Collectors.toCollection(ArrayList::new));

        //System.out.println(studentSortedArrayList.toString());
        // 7. Собрать в список всех учеников с именем == someName

        //  8. Собрать Map<Student.Gender, Integer>,
        //  где Student.Gender - пол,
        //  Integer - суммарный возраст учеников данного пола
        Map<Student.Gender, Integer> sumAgeStudent= students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.summingInt(student ->
                                LocalDate.now().getYear() - student.getBirth().getYear())));

    }
}
