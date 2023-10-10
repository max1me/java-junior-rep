package homework.homework05;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len, min = 0, max = 0, avg = 0;
        System.out.println("Введите размер массива");
        len = scanner.nextInt();
        if (len > 0) {
            int[] arr = new int[len];

            for (int i = 0; i < len; i++) {
                arr[i] = (int) (Math.random() * 1000);
                if (arr[i] < min || i == 0) {
                    min = arr[i];
                }
                if (arr[i] > max || i == 0) {
                    max = arr[i];
                }
                avg += arr[i];
            }

            System.out.println("Массив " + Arrays.toString(arr));
            System.out.println("Минимум " + min);
            System.out.println("Максимум " + max);
            System.out.println("Среднее " + (double) avg / len);
        } else {
            System.out.println("Введен некорректный размер");
        }
    }
}
