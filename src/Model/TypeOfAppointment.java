package Model;

public class TypeOfAppointment extends Appointments{
    private String type;
    public TypeOfAppointment(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
@Override
    public String toString(){
        return(type);
    }
}
