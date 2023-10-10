package homework.homework05;

import java.util.Arrays;
public class Task01 {
    public static void main(String[] args) {
        int[] arr = new int[15];
        int min = 10;
        for (int i = 0; i < arr.length;i++) {
            arr[i] = min;
            min += 4;
        }
        System.out.println(Arrays.toString(arr));
    }
}
