package DAO.DAOInterfaces;

import Entity.Client;

import java.util.List;

/**
 * Created by root on 14/02/17.
 */
public interface ClientDAO {

    List<Client> getAllClient();
    Client getClientById(int id);
    void createClient(Client client);
    void deleteClient(int id);
    Client updateClientPassword(Client client);
    Client updateClientEmail(Client client);
    Client updateClientPhone(Client client);
    Client findClientByLoginAndPassword(String login, String password);

}
