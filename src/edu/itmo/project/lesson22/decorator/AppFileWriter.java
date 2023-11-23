package edu.itmo.project.lesson22.decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppFileWriter implements AppLogger {
    private String fileName;

    public AppFileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String s) {
        Path path = Paths.get("./resources/",this.fileName);
        try {
            if (Files.exists(path)) Files.delete(path);
            Files.createFile(path);
            Files.writeString(path, s, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("Данные не были записаны");
        }
    }
}
