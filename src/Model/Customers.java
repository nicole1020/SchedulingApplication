package Model;

import java.time.ZoneId;

public class Customers {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String postalCode;
    private int phone;
    private ZoneId divisionID;

    public Customers( String customerName, String customerAddress, String postalCode, int phone,int customerID,  ZoneId divisionID){

        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.postalCode = postalCode;
        this.phone = phone;
        this.customerID = customerID;
        this.divisionID = divisionID;
    }

    public Customers(String customer_name, String address, String postal_code, int phone, int customer_id, int division_id) {
    }

    public int getCustomerID() {
        return customerID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getCustomerAddress(){
        return customerAddress;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public int getPhone(){
        return phone;
    }
    public ZoneId getDivisionID(){
        return divisionID;
    }
}
