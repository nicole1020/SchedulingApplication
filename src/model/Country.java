package model;
/**
 *
 * @author Nicole Mau
 * Initializing Country Class extends Customers
 */

public class Country extends Customers{
    private Integer countryID;
    private String countryName;

    /**
     *
     * @param countryID this is the country id number
     * @param countryName this is the country name
     */
    public Country (Integer countryID, String countryName){
        this.countryID = countryID;
        this.countryName = countryName;
    }

    /**
     *
     * @return customers countryID number
     */
    public Integer getCountryID() {
        return countryID;
    }
    /**
     *
     * @return customer's country name
     */
    public String getCountryName() {
        return countryName;
    }
    /**
     *
     * @return countryName to populate as a string instead of database location
     */
    public String toString(){
        return(countryName );
    }

   
}

