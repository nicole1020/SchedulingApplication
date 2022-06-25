package model;
/**
 *
 * @author Nicole Mau
 */



// Initializing Address Class extends Customers

public class Address extends Customers {

    private int divisionID;
    private String division;

    public Address(int division_ID, String division) {


        this.divisionID = division_ID;
        this.division = division;

    }
//get divisionID
    public int getDivisionID() {
        return divisionID;
    }
    //get getDivision
    public String getDivision(){
        return division;
    }
   @Override

    public String toString(){
        return("["+divisionID +"] " + division );
    }



}



