package edu.itmo.project.lesson24.homework;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Homework25 {
    public static void main(String[] args) {
        String text = "Текст для шифрования";
        String key = "key";
        //byte[] byteArray01 = {0, 0, 1, 0, 1, 0};
        byte[] byteArray01 = text.getBytes(StandardCharsets.UTF_8);
        //byte[] byteArray02 = {1, 1, 1, 1};
        byte[] byteArray02 = key.getBytes(StandardCharsets.UTF_8);
        byte[] byteArray03 = new byte[text.length()];

        /*for (int i = 0; i < byteArray01.length; i++) {
            byteArray03[i] = (byte)(byteArray01[i] ^ byteArray02[i]);
        }*/
        System.out.println(text);
        byteArray03 = XOR.xor(byteArray01, byteArray02);
        System.out.println(new String(byteArray03, StandardCharsets.UTF_8));
        byteArray03 = XOR.xor(byteArray03, byteArray02);
        System.out.println(new String(byteArray03, StandardCharsets.UTF_8));

        try (FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
            XOROutput xorOutput = new XOROutput(fileOutputStream, key)) {
            xorOutput.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream fileInputStream = new FileInputStream("out.txt");
            XORInput xorInput = new XORInput(fileInputStream, key)) {
            byte[] array = new byte[fileInputStream.available()];
            int readBytes = xorInput.read(array);
            System.out.println(new String(array, StandardCharsets.UTF_8));
            //System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    //InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    //XOROutput xorOutput = new XOROutput()

    //XORInput xorInput = new XORInput(inputStream, key);

}
