package edu.itmo.project.lesson24.homework;

public class XOR {
    public static void xor(byte[] text, byte[] key) {
        if (text == null || key == null) throw new IllegalArgumentException("text, key != null");
        for (int i = 0; i < text.length; i++) {
            text[i] = (byte) (text[i] ^ key [i % key.length]);
        }
    }
}
