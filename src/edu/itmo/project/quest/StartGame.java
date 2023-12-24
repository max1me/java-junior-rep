package edu.itmo.project.quest;

public class StartGame implements Menu{
    public final String commandName = "Начать игру";
    private Game game;

    public StartGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        this.game.startGame();
    }

    @Override
    public String getName() {
        return commandName;
    }
}
