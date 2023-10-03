package homework02;

public class Homework2 {
    public static void main(String[] args) {
        /*объявите переменные для хранения информации об общем количестве писем и о количестве отправленных писем.
        Присвойте значения этим переменным. Выведите в консоль, сколько писем осталось отправить.*/
        int lettersTotal = 987654321, lettersSent = 123456789;
        System.out.println("осталось отправить: " + (lettersTotal - lettersSent));

        /*Объявить и инициализировать переменные для хранения времени (в часах) и расстояния (в километрах).
        Найти и вывести в консоль скорость, выраженную в метрах в секунду.*/
        int distance = 650, hours = 12;
        System.out.println("скорость в метрах в секунду: " + (distance * 1000 / (hours * 60 * 60)));

        /*Найти сумму цифр целого положительного двузначного числа. Результат вывести в консоль.*/
        int number = 95, digitSum;

        digitSum = number % 10 + number / 10;
        System.out.println("Сумма цифр целого положительного двузначного числа " + number + ": " + digitSum);

        /*Поменять значения 2х переменных местами, используя арифметические операторы. Результат вывести в консоль.*/
        int a = 100, b = 999;
        System.out.println("a = " + a + ", b = " + b);
        a = a + b;
        System.out.println("a = " + a + ", b = " + b);
        b = a - b;
        System.out.println("a = " + a + ", b = " + b);
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);
    }
}
