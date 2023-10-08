package homework.homework04;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1, max = 100, mid, intValue;

        while (true) {
            mid = (min + max) / 2;
            System.out.println("Число больше " + mid + "?");
            intValue = scanner.nextInt();
            if (intValue == 1) {
                min = mid + 1;
            } else {
                if (min == mid) {
                    System.out.println("Вы загадали число " + min);
                    break;
                }
                System.out.println("Число равно " + mid + "?");
                intValue = scanner.nextInt();
                if (intValue == 1) {
                    System.out.println("Вы загадали число " + mid);
                    break;
                } else {
                    max = mid - 1;
                }
            }
        }
    }
}
