package Model;

public class updateCustomer extends Customers {

private String divisionName;
    public updateCustomer(int customer_id, String customerName, String address, String postalCode, String phone, String divisionName) {
        super(customer_id, customerName, address, postalCode, phone, divisionName);

    }

}