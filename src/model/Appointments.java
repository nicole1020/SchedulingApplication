package model;


import java.time.LocalDateTime;

/**
 *
 * @author Nicole Mau
 */

// initialize private access: (appointmentID:int, title:string, description:string, location:string, contact:int, type:string, startDateTime:LocalDateTime, endDateTime:LocalDateTime, customerID:int, userID:int)
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



// initialize public access: (appointmentID:int, title:string, description:string, location:string, contact:int, type:string, startDateTime:LocalDateTime, endDateTime:LocalDateTime, customerID:int, userID:int)

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
    public int getCustomerID() {
        return customerID;
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

    public Integer getContact() {
        return contact;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }


    public int getUserID() {
        return userID;
    }


    public String toString() {
        return (type);
    }


}

