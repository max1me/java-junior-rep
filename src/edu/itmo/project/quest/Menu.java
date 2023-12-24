package edu.itmo.project.quest;

public interface Menu {
    void execute();
    String getName();
    default boolean isAvailable() {
        return true;
    }
}
