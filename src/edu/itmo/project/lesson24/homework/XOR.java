package edu.itmo.project.lesson24.homework;

public class XOR {
    public static byte[] xor(byte[] text, byte[] key) {
        if (text == null || key == null) throw new IllegalArgumentException("text, key != null");
        byte[] result = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte) (text[i] ^ key [i % key.length]);
        }
        return result;
    }
}
