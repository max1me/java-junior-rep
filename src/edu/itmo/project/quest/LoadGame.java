package edu.itmo.project.quest;

import java.io.IOException;

public class LoadGame implements Menu{
    public final String commandName = "Загрузить игру";
    private Game game;
    private boolean isAvailable = false;
    @Override
    public void execute() {
        try {
            game.loadGame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LoadGame(Game game) {
        this.game = game;
        this.isAvailable = this.game.checkSaveFile();
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
