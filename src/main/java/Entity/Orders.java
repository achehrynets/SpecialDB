package Entity;

/**
 * Created by root on 21/02/17.
 */
public class Orders {
    private int orders_id;
    private int client_id;
    private int payment_type_id;
    private String orders_status;

    public Orders() {
    }

    public Orders(int orders_id, int client_id, int payment_type_id, String orders_status) {
        this.orders_id = orders_id;
        this.client_id = client_id;
        this.payment_type_id = payment_type_id;
        this.orders_status = orders_status;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getOrders_status() {
        return orders_status;
    }

    public void setOrders_status(String orders_status) {
        this.orders_status = orders_status;
    }
}
