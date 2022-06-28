package model;
/**
 *
 * @author Nicole Mau
 * Initializing Customers Class
 */

public class Customers {

    private String customerName;
    private String customerAddress;
    private String postalCode;
    private String phone;
    private int customerID;
    private String country;
    private String division;

    /**
     *
     * @param Customer_Name customer's first and last names
     * @param Address customer's address
     * @param Postal_Code customer's postal code
     * @param phone customer's phone number
     * @param customer_id customer's id number
     * @param Country customer's country name
     * @param Division customer's division of residence
     */
    public Customers(String Customer_Name, String Address, String Postal_Code, String phone, int customer_id, String Country, String Division) {
        this.customerName = Customer_Name;
        this.customerAddress = Address;
        this.postalCode = Postal_Code;
        this.phone = phone;
        this.customerID = customer_id;
        this.country = Country;
        this.division = Division;


    }

    /**
     *
     * @param Country customer country name
     */

    public Customers(String Country) {
        this.country = Country;
    }


    public Customers() {

    }


    public Customers(int customer_id) {

    this.customerID = customer_id;}

    /**
     *
     * @return customers customer ID number
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return customers full name
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     *
     * @return customers address
     */
    public String getCustomerAddress() {
        return customerAddress;
    }
    /**
     *
     * @return customers postal code
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     *
     * @return customers phone number
     */
    public String getPhone() {
        return phone;
    }
    /**
     *
     * @return customers country
     */
    public String getCountry() {
        return country;
    }
    /**
     *
     * @return customers division
     */
public String getDivision(){
        return division;
}
    @Override
/**
 *
 * @return customerID to populate as a string instead of database location
 */
    public String toString() {
        return ("["+customerID +"]" );
    }

}
