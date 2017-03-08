package Services;

import DAO.ClientDAOImpl;
import DAO.DAOInterfaces.ClientDAO;
import Entity.Client;
import Exceptions.ClientServiceException;
import Exceptions.DBException;
import Exceptions.LoginParametersException;
import Services.ServicesInterfaces.ClientController;

import java.util.List;

/**
 * Created by root on 07/03/17.
 */
public class ClientControllerImpl implements ClientController{

    private TransactionExecutor transactionExecutor;
    private ClientDAO clientDAO;

    public ClientControllerImpl() {
        this.transactionExecutor = new SQLTransactionExecutor();
        this.clientDAO = new ClientDAOImpl();
    }

    public Client login(final String login, final String password) {
        Client client = null;
        try {
            client = (Client) transactionExecutor.executeTransaction(new Transaction() {
                public Object execute() {
                    Client cl = clientDAO.findClientByLoginAndPassword(login, password);
                    return cl;
                }
            });
        } catch (DBException ex) {
            throw new ClientServiceException("Cant execute login");
        }
        return client;
    }

    public void registerClient(Client client) {

    }

    public void deleteClient(int id) {

    }

    public List<Client> getAllCLient() {
        return null;
    }

    public void updateClient(Client client) {

    }
}
