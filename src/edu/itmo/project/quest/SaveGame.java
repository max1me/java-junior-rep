package edu.itmo.project.quest;

import java.io.IOException;

public class SaveGame implements Menu {
    public final String commandName = "Сохранить игру";
    private boolean isAvailable = false;
    private Game game;
    @Override
    public void execute() {
        try {
            game.saveGame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SaveGame(Game game) {
        this.game = game;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    @Override
    public String getName() {
        return commandName;
    }
    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
