package model;
/**
 *
 * @author Nicole Mau
 *  Initializing Address Class extends Customers
 */





public class Address extends Customers {

    private int divisionID;
    private String division;

    /**
     *
     * @param division_ID division id number
     * @param division name of division
     */
    public Address(int division_ID, String division) {


        this.divisionID = division_ID;
        this.division = division;

    }
    /**
     *
     * @return divisionID
     */
    public int getDivisionID() {
        return divisionID;
    }
    /**
     *
     * @return division
     */
    public String getDivision(){
        return division;
    }
   @Override
/**
 *
 * @return divisionID and division populate as a string instead of database location
 */
    public String toString(){
        return("["+divisionID +"] " + division );
    }



}



