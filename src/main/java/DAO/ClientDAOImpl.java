package DAO;

import DAO.DAOInterfaces.ClientDAO;
import Entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    private final static String INSERT_CLIENT = "INSERT INTO client (name, surname, birthday, login, password, " +
            "mail, phone, valid, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String GET_CLIENT_BY_ID = "SELECT * FROM client WHERE client_id = ?;";
    private final static String GET_ALL_CLIENT = "SELECT * FROM client;";
    private final static String DELETE_CLIENT_BY_ID = "DELETE FROM client WHERE client_id = ?;";
    private final static String UPDATE_CLIENT_PASSWORD = "UPDATE client SET password = ? WHERE client_id = ?";
    private final static String UPDATE_CLIENT_EMAIL = "UPDATE client SET email = ? WHERE client_id = ?";
    private final static String UPDATE_CLIENT_PHONE = "UPDATE client SET phone = ? WHERE client_id = ?";
    private final static String FIND_CLIENT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM client WHERE login = ? AND password = ?";

    private JDBCConnect connect = new JDBCConnect();
    private Connection con = connect.getConnection();

    private void closeConnection() {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error in closing connection");
                ex.printStackTrace();
            }
    }

    private PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Error in SQL");
            ex.printStackTrace();
        }
        return ps;
    }

    private void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void closeResultSet (ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error in closing ResulSet");
                ex.printStackTrace();
            }
        }
    }

    public List<Client> getAllClient() {
        PreparedStatement ps = getPreparedStatement(GET_ALL_CLIENT);
        ResultSet rs = null;
        List clientsList = new ArrayList();
        Client client = null;
        try {
            rs = ps.executeQuery();
            while (!rs.next()) {
                client = new Client();
                client.setClient_id(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setSurname(rs.getString(3));
                client.setBirthday(rs.getDate(4));
                client.setLogin(rs.getString(5));
                client.setEmail(rs.getString(6));
                client.setPhone(rs.getString(7));
                client.setValid(rs.getBoolean(8));
                client.setRole(rs.getString(9));
                clientsList.add(client);
            }
        } catch (SQLException ex) {
            System.out.println("Error in getAllClient method (ClientDAOImpl)");
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }


        return clientsList;
    }

    public Client getClientById(int id) {
        Client client = new Client();
        PreparedStatement ps = getPreparedStatement(GET_CLIENT_BY_ID);
        ResultSet rs = null;
        try {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            client.setClient_id(rs.getInt(1));
            client.setName(rs.getString(2));
            client.setSurname(rs.getString(3));
            client.setBirthday(rs.getDate(4));
            client.setLogin(rs.getString(5));
            client.setPassword(rs.getString(6));
            client.setEmail(rs.getString(7));
            client.setPhone(rs.getString(8));
            client.setValid(rs.getBoolean(9));
            client.setRole(rs.getString(10));

        } catch (SQLException ex) {
            System.out.println("Error in getClientById");
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return client;
    }

    public void createClient(Client client) {
        PreparedStatement ps = getPreparedStatement(INSERT_CLIENT);
        try {
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setDate(3, (Date) client.getBirthday());
            ps.setString(4, client.getLogin());
            ps.setString(5, client.getPassword());
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getPhone());
            ps.setBoolean(8, client.getValid());
            ps.setString(9, client.getRole());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error in create user : SQLex");
            ex.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    public void deleteClient(int id) {
        PreparedStatement ps = getPreparedStatement(DELETE_CLIENT_BY_ID);
        try {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error in deleteClient");
            ex.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
    }

    public Client updateClientPassword(Client client) {
        PreparedStatement ps = getPreparedStatement(UPDATE_CLIENT_PASSWORD);
        try {
            ps.setString(1, client.getPassword());
            ps.setInt(2, client.getClient_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error in updateClientPassword");
            ex.printStackTrace();
            client = null;
        } finally {
            closePreparedStatement(ps);
        }
        return client;
    }

    public Client updateClientEmail(Client client) {
        PreparedStatement ps = getPreparedStatement(UPDATE_CLIENT_EMAIL);
        try {
            ps.setString(1, client.getEmail());
            ps.setInt(2, client.getClient_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error in updateClientEmail");
            ex.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
        return client;
    }

    public Client updateClientPhone(Client client) {
        PreparedStatement ps = getPreparedStatement(UPDATE_CLIENT_PHONE);
        try {
            ps.setString(1, client.getPhone());
            ps.setInt(2, client.getClient_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error in updateClientPhone");
            ex.printStackTrace();
        } finally {
            closePreparedStatement(ps);
        }
        return client;
    }

    public Client findClientByLoginAndPassword(String login, String password) {
        Client client = new Client();
        PreparedStatement ps = getPreparedStatement(FIND_CLIENT_BY_LOGIN_AND_PASSWORD);
        ResultSet rs = null;
        try {
            ps.setString(1, login);
            ps.setString(2, password);
            //Check
            rs = ps.executeQuery();
            rs.next();
            client.setClient_id(rs.getInt(1));
            client.setName(rs.getString(2));
            client.setSurname(rs.getString(3));
            client.setBirthday(rs.getDate(4));
            client.setLogin(rs.getString(5));
            client.setPassword(rs.getString(6));
            client.setEmail(rs.getString(7));
            client.setPhone(rs.getString(8));
            client.setValid(rs.getBoolean(9));
            client.setRole(rs.getString(10));
        } catch (SQLException ex) {
            System.out.println("Error in findClient");
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return client;
    }
}
