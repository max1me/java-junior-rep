package homework.homework03;

public class Homework3 {
    public static void main(String[] args) {

        /*Задача #1 на Math.random() и ветвление*/
        int min = 10, max = 500, randomNum, intervalMin = 25, intervalMax = 200;
        randomNum = min + (int) (Math.random() * max);

        if (randomNum > intervalMin && randomNum < intervalMax) {
            System.out.println("Число " + randomNum + " содержится в интервале (" + intervalMin + ";" + intervalMax + ")");
        } else {
            System.out.println("Число " + randomNum + " не содержится в интервале (" + intervalMin + ";" + intervalMax + ")");
        }

        /*Задача #2 на if else*/
        int currentScoreValue = 77, place = 0;
        if (currentScoreValue >= 90) {
            place = 1;
        } else if (currentScoreValue >= 80 && currentScoreValue <= 89) {
            place = 2;
        } else if (currentScoreValue >= 70 && currentScoreValue <= 79) {
            place = 3;
        }
        System.out.println(place > 0 ? "Пользователь занял место " + place  : "Пользователь не занял никакое место");

        /*Задача #3 на if else*/
        int x = 1, y = -1, q =  0;
        if (x > 0 && y > 0) {
            q = 1;
        } else if (x < 0 && y > 0) {
            q = 2;
        } else if (x < 0 && y < 0) {
            q = 3;
        } else if (x > 0 && y < 0) {
            q = 4;
        }
        System.out.println(q > 0 ? "Точка принадлежит " + q + " четверти"  : "Точка не принадлежит никакой четверти");

        /*Задача #4 на switch*/
        int monthNumber = 2, dayCount = 0;
        boolean isLeap = true;
        switch (monthNumber) {
            case 1 : dayCount = 31;break;
            case 2 : dayCount = isLeap ? 29 : 28; break;
            case 3 : dayCount = 31; break;
            case 4 : dayCount = 30; break;
            case 5 : dayCount = 31; break;
            case 6 : dayCount = 30; break;
            case 7 : dayCount = 31; break;
            case 8 : dayCount = 31; break;
            case 9 : dayCount = 30; break;
            case 10 : dayCount = 31; break;
            case 11 : dayCount = 30; break;
            case 12 : dayCount = 31; break;
        }
        System.out.println("Количество дней в году: " + dayCount);

        /*Задача #5 на switch*/
        int couponNumber = 3333;
        double resultSum = 123.5;
        switch (couponNumber) {
            case 1111 : resultSum = resultSum * 0.9; break;
            case 3333 : resultSum = resultSum * 0.8; break;
            case 5555 : resultSum = resultSum * 0.7; break;
        }
        System.out.println("Сумма покупки: " + resultSum);
    }
}
