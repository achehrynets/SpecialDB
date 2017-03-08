package Entity;

/**
 * Created by root on 07/03/17.
 */
public class PaymentType {
    private int payment_type_id;
    private String payment_name;

    public PaymentType() {
    }

    public PaymentType(int payment_type_id, String payment_name) {
        this.payment_type_id = payment_type_id;
        this.payment_name = payment_name;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }
}
