package Model;

public class Customers {

    private String customerName;
    private String customerAddress;
    private String postalCode;
    private String phone;
  /** private Timestamp createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;*/
  private int customerID;
    private String country;
    private String division;

    public Customers(String Customer_Name, String Address, String Postal_Code, String phone, int customer_id, String Country, String Division ) {
        this.customerName = Customer_Name;
        this.customerAddress = Address;
        this.postalCode = Postal_Code;
        this.phone = phone;
        /**this.createDate= Create_Date;
        this.createdBy = Created_By;
        this.lastUpdate = Last_Update;
        this.lastUpdateBy = Last_Update_By;*/
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

    public String getPhone() {
        return phone;
    }
    /**
    public Timestamp getCreateDate(){
        return createDate;
    }
    public String getCreatedBy(){
        return createdBy;
    }
    public Timestamp getLastUpdate(){
        return lastUpdate;
    }
    public String getLastUpdateBy(){
        return lastUpdateBy;
    }*/

public String getCountry(){
        return country;
}
    public String getDivision() {
        return division;
    }
}