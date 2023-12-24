package edu.itmo.project.quest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Objects;

public class Game {
    private Paragraph paragraph;
    private String userName;
    private String path = "src/edu/itmo/project/quest/";

    public Game(String userName) {
        Objects.requireNonNull(userName);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    private String getPath() {
        return this.path + "save_" + userName + ".bin";
    }

    public Paragraph getParagraph() {
        return paragraph;
    }
    public void startGame() {
        this.paragraph = Paragraph.getGame();
        this.paragraph.game();
    }

    public void resumeGame() {
        this.paragraph.game();
    }
    public boolean checkSaveFile() {
        return Files.exists(Path.of(getPath()), LinkOption.NOFOLLOW_LINKS);
    }
    public void saveGame() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getPath()));
        try {
            objectOutputStream.writeObject(paragraph.getRealParagraph());
            System.out.println("Игра успешно сохранена");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении игры");
            throw new RuntimeException(e);
        }
    }
    public void loadGame() throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getPath()));
        try {
            this.paragraph = (Paragraph) objectInputStream.readObject();
            System.out.println("Игра успешно загружена  с параграфа ["+paragraph.getName()+"]");
            this.paragraph.game();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке игры");
            throw new RuntimeException(e);
        }
    }
}
