package Model;

public class CustomerIDsAppointments extends Appointments{
    private int customerID;

    public CustomerIDsAppointments(int customer_id){
        this.customerID= customer_id;
    }

    public String toString(){
        return String.valueOf((customerID));
    }
}
