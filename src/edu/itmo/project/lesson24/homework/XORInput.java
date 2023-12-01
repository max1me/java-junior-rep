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
        int readBytes = super.read(b);
        XOR.xor(b, key.getBytes(StandardCharsets.UTF_8));
        return readBytes;
    }
}
