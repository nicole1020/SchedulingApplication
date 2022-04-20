package Model;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String type;
    private Date startDate;
    private Time startTime;
    private ZonedDateTime endTime;
    private ZonedDateTime endDate;
    private int customerID;
    private int userID;

    public Appointments(int Appointment_ID, String Title, String Description, String Location, int Contact_ID, String Type, Date Start, ZonedDateTime End, int Customer_ID, int User_ID) {
        this.appointmentID = Appointment_ID;
        this.title = Title;
        this.description = Description;
        this.location = Location;
        this.contact = Contact_ID;
        this.type = Type;
        this.startDate = Start;
        this.endDate = End;
        this.customerID = Customer_ID;
        this.userID = User_ID;

    }


    public Appointments(Integer customer_id) {
        this.customerID = customer_id;
    }

    public Appointments(String type) {
        this.type = type;
    }

    public Appointments() {

    }





    public Appointments(Time start, Date startDate) {
        this.startDate = startDate;
        this.startTime = start;
    }

   // public Appointments(int appointment_id, String title, String description, String location, int contact_id, String type, String start, String end, int customer_id, int user_id) {
   // }

    public ZonedDateTime getEndTime(){return endTime;}
    public Time getStartTime(){return startTime;}


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

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDateTime() {
        return endDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getUserID() {
        return userID;
    }
}

