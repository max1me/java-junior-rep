package edu.itmo.project.lesson24;

import java.io.IOException;

public class Resource implements AutoCloseable {
    public Resource() {
    }

    public void resourceVoid() throws IOException {

    }
    @Override
    public void close() {
        System.out.println("логика, связанная с закрытием ресурса");
    }
}
