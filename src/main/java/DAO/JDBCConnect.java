package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by root on 20/02/17.
 */
public class JDBCConnect {

    private static final String url = "jdbc:postgresql://localhost:5432/myDB";
    private static final String user = "jo1nsaint";
    private static final String password = "werd123312";

    private Connection connection = null;

    public JDBCConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC class load error");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Connection error");
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }



}
