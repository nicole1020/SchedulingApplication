package Model;



public class Address  {
    private int divisionID;
    private String division;
    private int countryID;
    private String country;

    public Address(int division_ID, String division, int country_ID, String country) {

        this.divisionID = division_ID;
        this.division = division;
        this.countryID = country_ID;
        this.country = country;
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


