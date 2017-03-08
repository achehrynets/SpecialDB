package Entity;

/**
 * Created by root on 07/03/17.
 */
public class OrdersProduct {

    private int orders_id;
    private int product_id;
    private int quantity;
    private double sum_price;

    public OrdersProduct() {
    }

    public OrdersProduct(int orders_id, int product_id, int quantity, double sum_price) {
        this.orders_id = orders_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.sum_price = sum_price;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum_price() {
        return sum_price;
    }

    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }
}
