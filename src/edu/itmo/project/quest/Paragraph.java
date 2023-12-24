package edu.itmo.project.quest;

import java.io.*;
import java.util.Scanner;

public class Paragraph implements Serializable {
    private String name;
    private String text;
    private Paragraph firstOption;
    private String firstOptionName;
    private Paragraph secondOption;
    private Paragraph realParagraph;
    private String secondOptionName;
    private boolean isSuccess = false;
    private boolean isEndOfGame = false;

    public Paragraph(String name, String text, Paragraph firstOption, Paragraph secondOption) {
        this.name = name;
        this.text = text;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.realParagraph = this;
    }
    public Paragraph(String name, String text, Paragraph firstOption, Paragraph secondOption, boolean isSuccess) {
        this(name, text, firstOption, secondOption);
        this.isSuccess = isSuccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Paragraph getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(Paragraph firstOption) {
        this.firstOption = firstOption;
    }

    public Paragraph getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(Paragraph secondOption) {
        this.secondOption = secondOption;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isEndOfGame() {
        return isEndOfGame;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFirstOptionName() {
        return firstOptionName;
    }

    public void setFirstOptionName(String firstOptionName) {
        this.firstOptionName = firstOptionName;
    }

    public String getSecondOptionName() {
        return secondOptionName;
    }

    public void setSecondOptionName(String secondOptionName) {
        this.secondOptionName = secondOptionName;
    }

    public Paragraph getRealParagraph() {
        return this.realParagraph;
    }

    public boolean checkEndOfGame() {
        if (this.firstOption == null && this.secondOption == null) {
            System.out.println(this.getText());
            if (this.isSuccess) {
                System.out.println("Вы выиграли!");
            } else {
                System.out.println("Вы проиграли!");
            }
            this.isEndOfGame = true;
            return true;
        }
        return false;
    }
    public String getOptions() {
        String options = null;
        if (this.getFirstOption() != null) {
            options = "1. " + (this.getFirstOptionName() == null ? this.getFirstOption().getName() : this.getFirstOptionName()) + "\n";
        }
        if (this.getSecondOption() != null) {
            options += "2. " + (this.getSecondOptionName() == null ? this.getSecondOption().getName() : this.getSecondOptionName()) + "\n";
        }
        options += "3. Выйти в главное меню";
        return options;
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(this.realParagraph.getText());
            System.out.println(this.realParagraph.getOptions());
            int option = scanner.nextInt();
            if (!this.realParagraph.checkEndOfGame()) {
                if (option == 1) {
                    this.realParagraph = this.realParagraph.getFirstOption();
                    if (this.realParagraph.checkEndOfGame()) {
                        this.realParagraph.isEndOfGame = true;
                        return;
                    }
                } else if (option == 2) {
                    this.realParagraph = this.realParagraph.getSecondOption();
                    if (this.realParagraph.checkEndOfGame()) {
                        this.realParagraph.isEndOfGame = true;
                        return;
                    }
                }
            } else return;
            if (option == 3) return;
        }
    }
    public static Paragraph getGame() {
        Paragraph game = new Paragraph("Лисенок",
                "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. " +
                        "Это утро не было исключением. Лисёнок пришёл на их обычное место встречи, " +
                        "но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. " +
                        "\" Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду." +
                        "\" - подумал Лисёнок. Как поступить Лисенку?", null, null);
        Paragraph returnHome = new Paragraph("Вернуться домой",
                "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи " +
                        "раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, " +
                        "но они разминулись. Наконец-то друзья нашли друг друга!", null, null, true);
        game.setFirstOption(returnHome);
        Paragraph goOnSearch = new Paragraph("Отправиться на поиски",
                "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. " +
                        "Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.",
                null,
                null);
        game.setSecondOption(goOnSearch);

        Paragraph goAlone = new Paragraph("Искать Бельчонка в одиночку",
                "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. " +
                        "Теперь его самого нужно искать.",
                null,
                null);
        goOnSearch.setSecondOption(goAlone);
        Paragraph askWolf = new Paragraph("Расспросить Волка",
                "Волк оказался вполне дружелюбным, но помочь не смог. " +
                        "Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?",
                returnHome,
                goAlone);
        askWolf.setFirstOptionName("Волк прав");
        Paragraph stealHoney = new Paragraph("Нужно попытаться выкрасть мёд немедленно",
                "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь.",
                null, null);
        Paragraph rest = new Paragraph("Поесть немного и передохнуть",
                "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. " +
                        "Лисёнку нужна помощь, он не сможет продолжить поиски.",
                null, null);
        Paragraph goToBear = new Paragraph("Скорее отнести мёд Медвежонку",
                "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, " +
                        "что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, " +
                        "что Белки не попадают в неприятности, и что Совам нельзя верить, " +
                        "он также уговаривал Лисёнка вернуться домой.",
                goAlone,
                returnHome);
        goToBear.setFirstOptionName("Медвежонок ничего не знает, нужно продолжить поиски");
        goToBear.setSecondOptionName("Может быть он прав и Лисёнок просто паникует");
        Paragraph wait = new Paragraph("Подождать, вдруг пчёлы улетят",
                "Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. " +
                        "Вдруг он понял, что очень голоден. Что же делать?",
                rest, goToBear);
        Paragraph searchHoney = new Paragraph("Нужно воспользоваться шансом и раздобыть мёд",
                "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, " +
                        "но и не найти друга он тоже боялся.",
                wait, stealHoney);
        Paragraph goToForrest = new Paragraph("Поверить Сове и отправиться вглубь леса",
                "В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, " +
                        "что знает, если Лисёнок принесёт ему мёда.",
                goAlone,
                searchHoney);
        goToForrest.setFirstOptionName("Нет, потрачено слишком много времени, нужно идти дальше");
        Paragraph askOwl = new Paragraph("Расспросить Сову",
                "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, " +
                        "бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно, " +
                        "если Бельчонок там, ему срочно нужна помощь.",
                goToForrest,
                goAlone);
        askOwl.setSecondOptionName("Сове не стоит верить");
        Paragraph askAnimals = new Paragraph("Попытаться разузнать о Бельчонке у лесных жителей",
                "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. " +
                        "Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. " +
                        "Кого выбрать?",
                askOwl,
                askWolf);
        goOnSearch.setFirstOption(askAnimals);
        return game;
    }
}
