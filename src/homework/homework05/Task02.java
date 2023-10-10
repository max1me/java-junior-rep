package homework.homework05;

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intValue, i = 0, j = 0;
        int[] arr01 = new int[5], arr02 = new int[5];

        //System.out.println(Arrays.toString(arr01));

        while(true) {
            System.out.println("Введите число");
            intValue = scanner.nextInt();
            if (intValue == 0) {
                System.out.println("Выход...");
                break;
            } else if (intValue < 0 && i < 5) {
                arr01[i] = intValue;
                i++;
            } else if (j < 5) {
                arr02[j] = intValue;
                j++;
            }
            if (i == 5 && j == 5) {
                System.out.println("Массивы заполнены");
                break;
            }
        }
        System.out.println("Массив 1" + Arrays.toString(arr01));
        System.out.println("Массив 2" + Arrays.toString(arr02));
    }
}
