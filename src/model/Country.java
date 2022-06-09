package model;

public class Country extends Customers{
    private Integer countryID;
    private String countryName;

    public Country (Integer countryID, String countryName){
        this.countryID = countryID;
        this.countryName = countryName;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public String getCountryName() {
        return countryName;
    }
    public String toString(){
        return(countryName );
    }

   
}

