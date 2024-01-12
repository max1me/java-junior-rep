package com.lessons.maven.fishing;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("fishing");
        EntityManager manager = factory.createEntityManager();
        Ships ship1 = new Ships("Победа", "Катер", 15.4, LocalDate.of(2023, 12, 31));
        Ships ship2 = new Ships("Рыболов", "Траулер", 100, LocalDate.of(1975, 01, 01));

        Workers workers1 = new Workers("Том", "Москва", "Капитан");
        Workers workers2 = new Workers("Джек", "Санкт-Петербург", "Капитан");
        Workers workers3 = new Workers("Джон", "Санкт-Петербург", "Рабочий");
        Workers workers4 = new Workers("Боб", "Сочи", "Рабочий");

        Sails sails1 = new Sails(LocalDate.of(2024, 01, 11), ship1);
        Sails sails2 = new Sails(LocalDate.of(2024, 01, 01), ship2);

        Crews crews1 = new Crews(sails1, workers1);
        Crews crews2 = new Crews(sails1, workers2);
        Crews crews3 = new Crews(sails2, workers3);
        Crews crews4 = new Crews(sails2, workers4);

        Banks banks1 = new Banks(sails1, "Ладога 1", "отличное", LocalDate.now().minusDays(1), LocalDate.now());
        Banks banks2 = new Banks(sails1, "Ладога 2", LocalDate.now().plusDays(3));

        Banks banks3 = new Banks(sails2, "Ладога 2", LocalDate.now().plusDays(3));
        Banks banks4 = new Banks(sails2, "Ладога 2", LocalDate.now().minusDays(1));
        Banks banks5 = new Banks(sails2, "Ладога 2", "Хорошее", LocalDate.now().minusDays(10), LocalDate.now().minusDays(3));

        Catches catches1 = new Catches(sails1, "Треска", 10000000.5);
        Catches catches2 = new Catches(sails1, "Лосось", 5000);
        Catches catches3 = new Catches(sails1, "Окунь", 123456789);
        Catches catches4 = new Catches(sails2, "Сельдь", 9999999);
        Catches catches5 = new Catches(sails2, "Килька", 987654321);

        manager.getTransaction().begin();

        manager.persist(ship1);
        manager.persist(ship2);

        manager.persist(workers1);
        manager.persist(workers2);
        manager.persist(workers3);
        manager.persist(workers4);

        manager.persist(sails1);
        manager.persist(sails2);

        manager.persist(crews1);
        manager.persist(crews2);
        manager.persist(crews3);
        manager.persist(crews4);

        manager.persist(banks1);
        manager.persist(banks2);
        manager.persist(banks3);
        manager.persist(banks4);
        manager.persist(banks5);

        manager.persist(catches1);
        manager.persist(catches2);
        manager.persist(catches3);
        manager.persist(catches4);
        manager.persist(catches5);

        manager.getTransaction().commit();

    }
}
