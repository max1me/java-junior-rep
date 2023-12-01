package edu.itmo.project.lesson24.homework;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class XORInput extends FilterInputStream {
    private String key;
    public XORInput(InputStream in, String key) {
        super(in);
        if (key == null) throw new IllegalArgumentException("key != null");
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        //System.out.println("read 0 " + new String(b, StandardCharsets.UTF_8));
        int readBytes = super.read(b);
        //System.out.println("readBytes 1 " + readBytes);
        //System.out.println("read 1 " + new String(b, StandardCharsets.UTF_8));
        b = XOR.xor(b, key.getBytes(StandardCharsets.UTF_8));
        System.out.println("xor " + new String(b, StandardCharsets.UTF_8));

        //readBytes = super.read(b);
        //System.out.println("readBytes 2 " + readBytes + " len " + b.length);
        //System.out.println("read 2 " + new String(b, StandardCharsets.UTF_8));
        return readBytes;
    }
}
