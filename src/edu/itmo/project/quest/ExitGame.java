package edu.itmo.project.quest;

public class ExitGame implements Menu {
    public final String commandName = "Выйти из игры";
    @Override
    public void execute() {
        System.out.println("Выход из программы...");
        System.exit(0);
    }

    @Override
    public String getName() {
        return commandName;
    }
}
