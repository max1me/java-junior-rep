package homework.homework04;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double f = Math.random() / Math.nextDown(1.0);
        int x = (int)(1 * (1.0 - f) + 9 * f);
        int intValue;
        System.out.println("Введите число");
        while (true) {
            intValue = scanner.nextInt();
            if (intValue == 0) {
                System.out.println("выход из программы");
                break;
            } else if (intValue == x) {
                System.out.println("Вы угадали");
                break;
            } else if (intValue > x) {
                System.out.println("загаданное число меньше");
            } else if (intValue < x) {
                System.out.println("загаданное число больше");
            }
        }
    }
}
