package DAO;

import DAO.DAOInterfaces.ClientDAO;
import Entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    private final static String INSERT_CLIENT = "INSERT INTO client (client_name, client_surname, client_birthday," +
            " client_login, client_password, client_email, client_phone, client_valid, client_role)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String GET_CLIENT_BY_ID = "SELECT * FROM client WHERE client_id = ?;";
    private final static String GET_ALL_CLIENT = "SELECT * FROM client;";
    private final static String DELETE_CLIENT_BY_ID = "DELETE FROM client WHERE client_id = ?;";
    private final static String UPDATE_CLIENT_PASSWORD = "UPDATE client SET client_password = ? WHERE client_id = ?";
    private final static String UPDATE_CLIENT_EMAIL = "UPDATE client SET client_email = ? WHERE client_id = ?";
    private final static String UPDATE_CLIENT_PHONE = "UPDATE client SET client_phone = ? WHERE client_id = ?";
    private final static String FIND_CLIENT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM client WHERE client_login = ? " +
            "AND client_password = ?";

    private Connection con;

    public ClientDAOImpl() {
        JDBCConnect jdbcConnect = new JDBCConnect();
        con = jdbcConnect.getConnection();
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
        List<Client> clientsList = new ArrayList<Client>();
        try {
            rs = ps.executeQuery();
            Client client;
            while (rs.next()) {
                client = new Client();
                client.setClient_id(rs.getInt("client_id"));
                client.setName(rs.getString("client_name"));
                client.setSurname(rs.getString("client_surname"));
                client.setBirthday(rs.getDate("client_birthday"));
                client.setLogin(rs.getString("client_login"));
                client.setEmail(rs.getString("client_email"));
                client.setPhone(rs.getString("client_phone"));
                client.setValid(rs.getBoolean("client_valid"));
                client.setRole(rs.getString("client_role"));
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
            client.setClient_id(rs.getInt("client_id"));
            client.setName(rs.getString("client_name"));
            client.setSurname(rs.getString("client_surname"));
            client.setBirthday(rs.getDate("client_birthday"));
            client.setLogin(rs.getString("client_login"));
            client.setPassword(rs.getString("client_password"));
            client.setEmail(rs.getString("client_email"));
            client.setPhone(rs.getString("client_phone"));
            client.setValid(rs.getBoolean("client_valid"));
            client.setRole(rs.getString("client_role"));

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
        Client client = null;
        System.out.println(login + " ~~~~ " + password);
        PreparedStatement ps = getPreparedStatement(FIND_CLIENT_BY_LOGIN_AND_PASSWORD);
        ResultSet rs = null;
        try {
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                client = new Client();
                client.setClient_id(rs.getInt("client_id"));
                client.setName(rs.getString("client_name"));
                client.setSurname(rs.getString("client_surname"));
                client.setBirthday(rs.getDate("client_birthday"));
                client.setLogin(rs.getString("client_login"));
                client.setPassword(rs.getString("client_password"));
                client.setEmail(rs.getString("client_email"));
                client.setPhone(rs.getString("client_phone"));
                client.setValid(rs.getBoolean("client_valid"));
                client.setRole(rs.getString("client_role"));
                System.out.println(client.toString());
            } else {
                client = null;
            }
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
