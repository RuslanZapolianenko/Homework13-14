package util;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import flyway.DatabaseMigration;
import service.ClientCrudService;
import service.PlanetCrudService;
import service.TicketCrudService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DatabaseMigration databaseMigration = new DatabaseMigration();
        databaseMigration.fwMigration();

        ClientCrudService clientCrudService = new ClientCrudService();
        Client newClient = new Client();
        newClient.setName("Thanos");
        clientCrudService.create(newClient);
        clientCrudService.delete(newClient);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet newPlanet = new Planet();
        newPlanet.setId("TITAN");
        newPlanet.setName("Titan");
        planetCrudService.create(newPlanet);
        planetCrudService.delete(newPlanet);

        TicketCrudService ticketCrudService = new TicketCrudService();
        Ticket newTicket = new Ticket();
        Date currentDate = new Date();
        newTicket.setCreatedAt(currentDate);
        newTicket.setClient(null);
        newTicket.setFromPlanet(null);
        newTicket.setToPlanet(null);
        ticketCrudService.create(newTicket);

    }
}
