package Model;

public class Customers {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String postalCode;
    private int phone;
    private int divisionID;

    public Customers(String customer_name, String address, String postal_code, int phone, int customer_id, int division_id) {
        this.customerName = customer_name;
        this.customerAddress = address;
        this.postalCode = postal_code;
        this.phone = phone;
        this.customerID = customer_id;
        this.divisionID = division_id;
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
    public int getDivisionID(){
        return divisionID;
    }
}
