package edu.itmo.project.fitness;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness();
        Client client = new Client("Иван", "Иванов", 1975);
        SportPass sportPass1 = new SportPass(PassType.UNLIM, client);
        fitness.addPass(Section.GROUP, sportPass1);
        fitness.addPasses(SportPass.getAbonements(Client.getDefaultClients()));
        fitness.showAbonements();

    }
}