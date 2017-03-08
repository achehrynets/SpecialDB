package DAO.DAOInterfaces;

import Entity.Orders;

import java.util.List;

/**
 * Created by root on 21/02/17.
 */
public interface OrdersDAO {
    List<Orders> getOrdersById(int id);
    void createOrder();
    void deleteOrder(int id);
}
