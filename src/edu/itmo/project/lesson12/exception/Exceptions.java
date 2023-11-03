package edu.itmo.project.lesson12.exception;

public class Exceptions {
    public static void main(String[] args) {
        int[] ints = new int[4];
        int index = 9;
//        ints[index] = 5; java.lang.ArrayIndexOutOfBoundsException
        Object object = "Hello";
        //Integer integer = (Integer) object;//java.lang.ClassCastException

        //System.out.println(4/0);//java.lang.ArithmeticException
        String s = null;
        //System.out.println(s.length());//java.lang.NullPointerException

        /*try {
            System.out.println(s.length());
        } catch (NullPointerException exception) {
            System.out.println("Ошибка");
        }*/

        /*try {

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ClassCastException e) {
            e.printStackTrace();
        }*/

        /*try {
            //C
            Integer integer = (Integer) object;
        } catch (NullPointerException | ClassCastException e) {
            System.out.println(e.getMessage());
        }*/

        try {
            Integer integer = (Integer) object;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
