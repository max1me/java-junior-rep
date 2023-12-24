package edu.itmo.project.quest;

public class ResumeGame implements Menu {
    public final String commandName = "Вернуться к игре";
    private boolean isAvailable = false;
    private Game game;

    public ResumeGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        System.out.println("ResumeGame " + this.game.getParagraph().getRealParagraph().getName());
        this.game.resumeGame();
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
        return isAvailable;
    }
}
