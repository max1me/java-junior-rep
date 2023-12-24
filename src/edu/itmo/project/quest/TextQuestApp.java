package edu.itmo.project.quest;

import java.util.ArrayList;
import java.util.Scanner;

public class TextQuestApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String userName = scanner.nextLine();
        Game game = new Game(userName);
        ArrayList<Menu> menuOptions = new ArrayList<>();
        ArrayList<Menu> currentMenuOptions;
        StartGame startGame = new StartGame(game);
        ResumeGame resumeGame = new ResumeGame(game);
        SaveGame saveGame = new SaveGame(game);
        LoadGame loadGame = new LoadGame(game);
        menuOptions.add(startGame);
        menuOptions.add(resumeGame);
        menuOptions.add(new ExitGame());
        menuOptions.add(saveGame);
        menuOptions.add(loadGame);
        while (true) {
            currentMenuOptions = new ArrayList<>();
            //Определение доступных пунктов меню
            for (Menu menu: menuOptions) {
                if (menu.isAvailable()) {
                    currentMenuOptions.add(menu);
                }
            }
            for (int i = 0; i < currentMenuOptions.size(); i++) {
                System.out.println( (i + 1) + ". " + currentMenuOptions.get(i).getName());
            }
            System.out.println("Введите число от 1 до " +  currentMenuOptions.size());

            int option = scanner.nextInt() - 1;
            if (option >= 0 && option < currentMenuOptions.size()) {
                currentMenuOptions.get(option).execute();
                //Проверка, что игру можно продолжить
                if (!game.getParagraph().getRealParagraph().isEndOfGame()) {
                    resumeGame.setAvailable(true);
                    saveGame.setAvailable(true);
                } else {
                    resumeGame.setAvailable(false);
                    saveGame.setAvailable(false);
                }
                loadGame.setAvailable(game.checkSaveFile());
            }
        }
    }
}
