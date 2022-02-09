package Model;

public class Customers {

    private String customerName;
    private String customerAddress;
    private String postalCode;
    private int phone;
    private int customerID;
    private String country;
    private String division;

    public Customers(String customer_name, String address, String postal_code, int phone, int customer_id, String Country, String Division ) {
        this.customerName = customer_name;
        this.customerAddress = address;
        this.postalCode = postal_code;
        this.phone = phone;
        this.customerID = customer_id;
        this.country = Country;
        this.division = Division;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getPhone() {
        return phone;
    }

public String getCountry(){
        return country;
}
    public String getDivision() {
        return division;
    }
}