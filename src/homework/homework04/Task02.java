package homework.homework04;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое положительное число");
        int intValue = scanner.nextInt();
        int sum = 0;
        while (intValue > 0) {
            sum = sum + intValue % 10;
            intValue = intValue / 10;
        }
        System.out.println(sum);
    }
}
