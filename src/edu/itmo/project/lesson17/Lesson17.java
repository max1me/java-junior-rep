package edu.itmo.project.lesson17;

import java.util.*;

public class Lesson17 {


    public static void main(String[] args) {

        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("Москва", 123);
        customers.put("Псков", 250);
        customers.put("Саратов", 555);
        customers.put("Псков", 777);
        customers.put(null, 888);

        System.out.println(customers.size());
        System.out.println(customers.isEmpty());

        customers.remove(null);
        customers.replace("Псков", 555);
        customers.replace("Москва", 123, 999);

        System.out.println(customers.get("Москва"));

        System.out.println(customers.getOrDefault("Москва", -1));

        if (customers.containsKey("Псков")) {
            System.out.println("Псков");
        }
        if (customers.containsValue(999)) {
            System.out.println("Значение 999 содержится");
        }
        Collection<Integer> customersValues = customers.values();

        Set<String> customersKeys = customers.keySet();

        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();

        for (Map.Entry<String, Integer> customersPair : customersPairs) {
            System.out.println(customersPair.toString());
        }
        System.out.println(getTowns(customers, 1000).toString());

        EnumMap<ClientAuthData.Role, List<ClientAuthData>> clientsByRole = new EnumMap<>(ClientAuthData.Role.class);
        clientsByRole.put(ClientAuthData.Role.USER, new ArrayList<>());
        clientsByRole.put(ClientAuthData.Role.ADMIN, new ArrayList<>());
        ClientAuthData data01 = new ClientAuthData("qqqq", "1234", ClientAuthData.Role.USER);
        clientsByRole.get(ClientAuthData.Role.USER).add(data01);

        addToClientsByRole(clientsByRole, new ClientAuthData("qqqq", "1234", ClientAuthData.Role.MODERATOR));

        EnumSet<ClientAuthData.Role> rolesFull = EnumSet.allOf(ClientAuthData.Role.class);
        EnumSet<ClientAuthData.Role> rolesEmpty = EnumSet.noneOf(ClientAuthData.Role.class);
        rolesEmpty.add(ClientAuthData.Role.ADMIN);
        rolesEmpty.add(ClientAuthData.Role.MODERATOR);
        EnumSet<ClientAuthData.Role> rolesEx = EnumSet.complementOf(EnumSet.of(ClientAuthData.Role.USER));

        TreeMap<String, List<String>> students = new TreeMap<>();
    }
    /*написать static метод, который принимает на вход
         EnumMap<ClientAuthData.Role, List<ClientAuthData>> map
         и возвращает Map<Sting, String> c парами userName - password
         в результирующий Map должны попасть userName и password
         пользователей (ClientAuthData.Role.USER)*/

    private static Map<String, String> getUserNamePassPairs(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map) {
        Map<String, String> userPassPair = new HashMap<>();
        for (ClientAuthData clientAuthData: map.get(ClientAuthData.Role.USER)) {
            userPassPair.put(clientAuthData.getUserName(), clientAuthData.getPassword());
        }
        return userPassPair;
    }

    private static void addToClientsByRole(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map, ClientAuthData clientAuthData) {
        if (map.get(clientAuthData.getRole()) == null) {
            map.put(clientAuthData.getRole(), new ArrayList<>());
        }
        map.get(clientAuthData.getRole()).add(clientAuthData);
    }

    private static ArrayList<String> getTowns(HashMap<String, Integer> customers, int max) {
        ArrayList<String> towns = new ArrayList<>();
        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();
        for (Map.Entry<String, Integer> customersPair : customersPairs) {
            if (customersPair.getValue() < max) {
                towns.add(customersPair.getKey());
            }
        }
        return towns;
    }
}
