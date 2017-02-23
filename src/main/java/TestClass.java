import java.sql.*;

/**
 * Created by root on 13/02/17.
 */
public class TestClass {

    static private final String url = "jdbc:postgresql://localhost:5432/myDB";
    static private final String user = "jo1nsaint";
    static private final String password = "werd123312";

    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("JDBC driver not found");
            cnfe.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException sqle) {
            System.out.println("Error in connection (trouble with Driver Manager)");
            sqle.printStackTrace();
        }

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM client;");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                String login = resultSet.getString(5);
                String password = resultSet.getString(6);
                String mail = resultSet.getString(7);
                String phone = resultSet.getString(8);
                boolean valid = resultSet.getBoolean(9);
                String role = resultSet.getString(10);

                System.out.println(id + " " + name + " " + surname + " " + birthday + " " + login + " " + password
                                    + " " + mail + " " + phone + " " + role + " " + valid);
            }
        }
        catch (SQLException ex) {
            System.out.println("Trouble in createStatement");
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            System.out.println("Invalid data from db");
            ex.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
            connection.close();

        } catch (NullPointerException ex) {
            System.out.println("NULL in closing connection");
        }
        catch (SQLException ex) {
            System.out.println("Error with close connection");
            ex.printStackTrace();
        }

    }
}
