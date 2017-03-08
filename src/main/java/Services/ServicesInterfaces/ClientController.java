package Services.ServicesInterfaces;

import Entity.Client;

import java.util.List;

/**
 * Created by root on 08/03/17.
 */
public interface ClientController {
    Client login(String login, String password);
    void registerClient(Client client);
    void deleteClient(int id);
    List<Client> getAllCLient();
    void updateClient(Client client);
}
