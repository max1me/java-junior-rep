package edu.itmo.project.lesson19;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Task19 {
    public static void main(String[] args) {
        // Написать реализацию методов task01 - task04
        // Перед выполнением посмотрите методы flatMap / flatMapToInt / map / mapToInt / allMatch / anyMatch / noneMatch
        // Некоторые из этих методов могут понадобиться при решении задач
    }

    public static Double task01(ArrayList<Article> articles){
        // Вернуть средний возраст авторов статей
        return null;
    }

    public static List<String> task02(ArrayList<Article> articles, Article.Category category){
        // Вернуть список email авторов статей категории == category
        return null;
    }
    public static List<Article> task03(ArrayList<Article> articles, Article.Category category, int min, int max){
        // Вернуть список статей категории == category,
        // возраст авторов которых попадает в диапазон от min до max
        List<Article> articleList = articles.stream()
                .filter(article -> article.getCategory().equals(category))
                .filter(article -> article.getAuthors().values().stream()
                        .allMatch(author -> {
                            int age = Period.between(author.getBirth(), LocalDate.now()).getYears();
                            return age > min && age < max;
                        })
                )
                .toList();

        return articleList;
    }
    public static List<Article> task04(ArrayList<Article> articles, Article.Category category){
        // Вернуть список статей категории == category, опубликованных сегодня
        return null;
    }
}
