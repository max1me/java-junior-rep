package edu.itmo.project.lesson13;

public class PrimitiveWrappers {
    public static void main(String[] args) {
        int num = 547;
        Integer count = 34;

        //автоупаковка - переменной класса-обертки присваивается значение примитива
        Integer age = 20;
        count = num;

        // автораспаковка - переменной примитивного типа присваивается значение обертки
        double price;
        Double value = 45.6;
        price = value;

        byte oneB = 1;

        Integer oneI = (int) oneB;
        print((int)oneB, (float)45.7);

        Integer x = 9;
        Integer y = 9;
        System.out.println(x == y);
        System.out.println(x.equals(y));

        Integer k = 900;
        Integer l = 900;
        System.out.println(k == l);
        System.out.println(k.equals(l));

    }

    private static void print(Integer i, Float f) {
        System.out.println(i);
        System.out.println(f);
    }

}
