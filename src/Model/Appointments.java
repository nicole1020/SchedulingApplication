package Model;


import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String type;
    private Date startDateTime;
    private Date endDateTime;
    private int customerID;
    private int userID;

    public Appointments(int Appointment_ID, String Title, String Description, String Location, int Contact_ID, String Type, Date Start, Date End, int Customer_ID, int User_ID) {
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

    public Date getStartDateTime() {
        return startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getUserID() {
        return userID;
    }
}

