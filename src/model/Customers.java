package model;
/**
 *
 * @author Nicole Mau
 */
// Initializing Customers Class
public class Customers {

    private String customerName;
    private String customerAddress;
    private String postalCode;
    private String phone;
    private int customerID;
    private String country;
    private String division;


    public Customers(String Customer_Name, String Address, String Postal_Code, String phone, int customer_id, String Country, String Division) {
        this.customerName = Customer_Name;
        this.customerAddress = Address;
        this.postalCode = Postal_Code;
        this.phone = phone;
        this.customerID = customer_id;
        this.country = Country;
        this.division = Division;


    }

    public Customers(String Country) {
        this.country = Country;
    }

    public Customers() {

    }

    public Customers(int customer_id) {

    this.customerID = customer_id;}


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

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

public String getDivision(){
        return division;
}
    @Override

    public String toString() {
        return String.valueOf((customerID));
    }

}
