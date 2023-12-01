package edu.itmo.project.lesson24.homework;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class XOROutput extends FilterOutputStream {
    private String key;
    public XOROutput(OutputStream out, String key) {
        super(out);
        if (key == null) throw new IllegalArgumentException("key != null");
        this.key = key;
    }

    @Override
    public void write(byte[] b) throws IOException {
        XOR.xor(b, key.getBytes(StandardCharsets.UTF_8));
        super.write(b);
    }
}
