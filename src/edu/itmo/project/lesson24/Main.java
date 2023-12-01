package edu.itmo.project.lesson24;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Resource resource01 = new Resource();

        try {
            resource01.resourceVoid();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
