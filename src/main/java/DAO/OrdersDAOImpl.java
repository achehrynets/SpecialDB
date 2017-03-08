package DAO;

import DAO.DAOInterfaces.OrdersDAO;
import Entity.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 27/02/17.
 */
public class OrdersDAOImpl implements OrdersDAO {

    private static final String GET_ORDERS_BY_ID = "SELECT * FROM order WHERE client_id = ?";
    private static final String INSERT_ORDER = "INSERT FROM orders ";
    private static final String DELETE_ORDER = "";


    private Connection con;

    public OrdersDAOImpl() {
        JDBCConnect jdbcConnect = new JDBCConnect();
        this.con = jdbcConnect.getConnection();
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
                System.out.println("Error in closing PrepareStatement");
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

    public List<Orders> getOrdersById(int id) {

    return null;
    }

    public void createOrder() {

    }

    public void deleteOrder(int id) {

    }
}
