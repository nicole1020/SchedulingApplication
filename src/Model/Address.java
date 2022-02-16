package Model;



public class Address {
    private String address;
    private int divisionID;
    private String division;
    private int countryID;
    private String country;

    public Address(String address, int division_ID, String division, int country_ID, String country) {
        this.address = address;
        this.divisionID = division_ID;
        this.division = division;
        this.countryID = country_ID;
        this.country = country;
    }

    public Address(String Country) {
        this.country = Country;
    }

    public String getAddress() {
        return address;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public String getDivision() {
        return division;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getCountry() {
        return country;
    }
}


