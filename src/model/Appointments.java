package model;


import java.time.LocalDateTime;

/**
 *
 * @author Nicole Mau
 */


// Initializing Appointments Class extends Customers
public class Appointments extends Customers {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String type;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int customerID;
    private int userID;

    public Appointments( int appointment_id, String  title, String description, String location,  int contact_id, String type, LocalDateTime start, LocalDateTime end,  int customer_id, int user_id) {
        this.appointmentID = appointment_id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact_id;
        this.type = type;
        this.startDateTime = start;
        this.endDateTime = end;
        this.customerID = customer_id;
        this.userID = user_id;
    }

    public Appointments(String type) {
        this.type = type;
    }

    public Appointments() {
    }

    public Appointments(int appointment_id, String  type, LocalDateTime start, int customer_id, int user_id) {
        this.appointmentID = appointment_id;
        this.type = type;
        this.startDateTime = start;
        this.customerID = customer_id;
        this.userID = user_id;

    }


    @Override
    //get CustomerID
    public int getCustomerID() {
        return customerID;
    }



    //get appointmentID
    public int getAppointmentID() {
        return appointmentID;
    }
    //get title
    public String getTitle() {
        return title;
    }
    //get description
    public String getDescription() {
        return description;
    }
    //get location
    public String getLocation() {
        return location;
    }
    //get contact
    public Integer getContact() {
        return contact;
    }
    //get type
    public String getType() {
        return type;
    }
    //get startDateTime
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    //get endDateTime
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    //get userID
    public int getUserID() {
        return userID;
    }


    public String toString() {
        return (type);
    }


}

