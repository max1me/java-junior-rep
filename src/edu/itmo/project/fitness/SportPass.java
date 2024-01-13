package edu.itmo.project.fitness;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class SportPass {
    private int number;
    private static int lastNumber;
    private LocalDateTime registrationDateTime;
    private LocalDateTime expirationDateTime;
    private Client client;
    private PassType type;

    public SportPass(PassType type, Client client, int period) {
        setClient(client);
        setType(type);
        setNumber();
        setRegistrationDateTime();
        if (type.equals(PassType.SINGLE)) {
            setExpirationDateTime(1);
        } else {
            setExpirationDateTime(period);
        }
    }
    public SportPass(PassType type, Client client) {
        setClient(client);
        setType(type);
        setNumber();
        setRegistrationDateTime();
        if (type.equals(PassType.SINGLE)) {
            setExpirationDateTime(1);
        } else {
            setExpirationDateTime(30);
        }
    }
    private void setNumber() {
        this.number = lastNumber + 1;
        lastNumber = this.number;
    }
    private void setRegistrationDateTime() {
        /*this.registrationDateTime = LocalDateTime.now();*/
        this.registrationDateTime = LocalDateTime.of(2024, 01, 13, 12, 0);
    }
    private void setExpirationDateTime(int period) {
        if (period < 1) throw new IllegalArgumentException("Введите корректный период действия абонемента");
        this.expirationDateTime = this.registrationDateTime.plusDays(period);
    }
    private void setClient (Client client) {
        if (client == null) throw new IllegalArgumentException("Введите корректного клиента");
        this.client = client;
    }
    private void setType (PassType type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public PassType getType() {
        return type;
    }

    public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public static ArrayList<SportPass> getAbonements(ArrayList<Client> clients) {
        Objects.requireNonNull(clients);
        ArrayList<SportPass> abonements = new ArrayList<>();
        for (Client client : clients) {
            abonements.add(new SportPass(PassType.values()[(int)(Math.random() * 2)], client));
        }
        return abonements;
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Номер абонемента: " + this.number);
        stringBuffer.append("\n");
        stringBuffer.append("Время регистрации абонемента: " + this.registrationDateTime.toString());
        stringBuffer.append("\n");
        stringBuffer.append("Время истечения абонемента: " + this.expirationDateTime.toString());
        stringBuffer.append("\n");
        stringBuffer.append(this.client.toString());
        stringBuffer.append("\n");
        stringBuffer.append(this.type.toString());
        return stringBuffer.toString();
    };
}
