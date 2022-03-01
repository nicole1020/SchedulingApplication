package Model;



public class Address extends Customers {

    private int divisionID;
    private String division;


    public Address(int division_ID, String division) {


        this.divisionID = division_ID;
        this.division = division;

    }


    public int getDivisionID() {
        return divisionID;
    }

    public String getDivision() {
        return division;
    }


   @Override

    public String toString(){
        return("["+divisionID +"] " + division );
    }
}



