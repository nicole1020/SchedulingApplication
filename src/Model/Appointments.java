package Model;


import java.sql.Time;

public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String type;
    private Time startDateTime;
    private Time endDateTime;
    private int customerID;
    private int userID;

    public Appointments(int Appointment_ID, String Title, String Description, String Location, int Contact_ID, String Type, Time Start, Time End, int Customer_ID, int User_ID) {
        this.appointmentID = Appointment_ID;
        this.title = Title;
        this.description = Description;
        this.location = Location;
        this.contact = Contact_ID;
        this.type = Type;
        this.startDateTime = Start;
        this.endDateTime = End;
        this.customerID = Customer_ID;
        this.userID = User_ID;

    }


    public int getAppointmentID() {
        return appointmentID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getContact() {
        return contact;
    }

    public String getType() {
        return type;
    }

    public Time getStartDateTime() {
        return startDateTime;
    }

    public Time getEndDateTime() {
        return endDateTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getUserID() {
        return userID;
    }
}

