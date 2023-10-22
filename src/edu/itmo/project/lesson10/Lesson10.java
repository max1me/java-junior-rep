package edu.itmo.project.lesson10;

import edu.itmo.project.lesson10.clonequals.Item;
import edu.itmo.project.lesson10.clonequals.Order;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson10 {
    public static void main(String[] args) {
        Item item01 = new Item("Карандаш", 12);
        Item item02 = new Item("Карандаш", 12);
        Item item03 = new Item("Ручка", 150);
        Item copyItem = item03.clone();

        System.out.println(item01);
        System.out.println(item02);
        System.out.println(item01 == item02);
        System.out.println(item01.equals(item02));
        Arrays.equals(new Item[] {item01, item02}, (new Item[] {item01, item02}));

        Order order01 = new Order(new Item[]{item01, item02});
        Order order02 = new Order(new Item[]{item01, item02});

        //order01.getItems()[0] = item03;
        Order copy = order01;
        System.out.println("System.out.println(copy == order01); " + (copy == order01));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя пользователя");
        String userName = scanner.nextLine();

        System.out.println("Пароль");
        String password = scanner.nextLine();

        System.out.println("Способ авторизации");
        String authType = scanner.nextLine();
        Auth auth = Auth.getAuth(authType);
        /*if (authType.equals("github")) {
            auth = new GAuth();
        } else {
            auth =new AppAuth();
        }*/

        auth.login(userName, password);


    }
}
