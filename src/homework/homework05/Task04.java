package homework.homework05;

public class Task04 {
    public static void main(String[] args) {
        int[] task04 = {88, 34, 12, 55, 90, 4, 10, 44};
        int len = 4, sum = 0, max;

        for (int i = 0; i < len; i++) {
            sum += task04[i];
        }
        max = sum;
        for (int i = len; i < task04.length; i++) {
            sum = sum - task04[i - len] + task04[i];
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println("Максимальная сумма = " + max);
    }
}
