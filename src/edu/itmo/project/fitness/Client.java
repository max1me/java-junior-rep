package edu.itmo.project.fitness;

import java.util.ArrayList;

public class Client {
    private String name;
    private String lastName;
    private short birthYear;

    public Client(String name, String lastName, int birthYear) {
        if (name == null || lastName == null || birthYear < 1930 || birthYear > 2010)
            throw new IllegalArgumentException("Введите корректные данные клиента");
        this.name = name;
        this.lastName = lastName;
        this.birthYear = (short)birthYear;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInfo() {
        return lastName + " " + name;
    }

    public static ArrayList<Client> getDefaultClients() {
        ArrayList<Client> clients = new ArrayList<>();
        String[] names = {"Артём",
                            "Александр",
                            "Роман",
                            "Евгений",
                            "Иван",
                            "Максим",
                            "Денис",
                            "Алексей",
                            "Дмитрий",
                            "Даниил",
                            "Сергей",
                            "Николай",
                            "Константин",
                            "Никита",
                            "Михаил",
                            "Борис",
                            "Виктор",
                            "Геннадий",
                            "Вячеслав",
                            "Владимир",
                            "Александр",
                            "Роман",
                            "Евгений",
                            "Иван",
                            "Денис",
                            "Алексей",
                            "Дмитрий",
                            "Даниил",
                            "Сергей",
                            "Николай",
                            "Константин",
                            "Никита",
                            "Михаил",
                            "Борис",
                            "Виктор",
                            "Геннадий",
                            "Вячеслав",
                            "Владимир",
                            "Александр",
                            "Алексей",
                            "Дмитрий",
                            "Даниил",
                            "Сергей",
                            "Николай",
                            "Константин",
                            "Никита",
                            "Михаил",
                            "Борис",
                            "Виктор",
                            "Геннадий",
                            "Вячеслав"};
        String[] lastNames = {"Иванов",
                                "Смирнов",
                                "Кузнецов",
                                "Попов",
                                "Васильев",
                                "Петров",
                                "Соколов",
                                "Михайлов",
                                "Новиков",
                                "Федоров",
                                "Морозов",
                                "Волков",
                                "Алексеев",
                                "Лебедев",
                                "Семенов",
                                "Егоров",
                                "Павлов",
                                "Козлов",
                                "Степанов",
                                "Николаев",
                                "Лебедев",
                                "Семенов",
                                "Егоров",
                                "Павлов",
                                "Михайлов",
                                "Новиков",
                                "Федоров",
                                "Морозов",
                                "Волков",
                                "Алексеев",
                                "Лебедев",
                                "Семенов",
                                "Егоров",
                                "Павлов",
                                "Козлов",
                                "Степанов",
                                "Николаев",
                                "Лебедев",
                                "Семенов",
                                "Соколов",
                                "Михайлов",
                                "Новиков",
                                "Федоров",
                                "Морозов",
                                "Волков",
                                "Алексеев",
                                "Лебедев",
                                "Семенов",
                                "Егоров",
                                "Павлов",
                                "Козлов"};
        for (int i = 0; i < names.length; i++) {
            clients.add(new Client(names[i], lastNames[i], (int)(Math.random() * (2010 - 1930) + 1930)));
        }
        return clients;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Имя клиента: " + this.name);
        stringBuffer.append("\n");
        stringBuffer.append("Фамилия клиента: " + this.lastName);
        stringBuffer.append("\n");
        stringBuffer.append("Год рождения клиента: " + this.birthYear);
        return stringBuffer.toString();
    }
}
