package Model;

public class updateCustomer extends Address {

private String division;
    public updateCustomer(int division_ID, String division) {
        super( division_ID, division);
this.division = division;
    }
public String getDivision(){
        return  division;
}
}