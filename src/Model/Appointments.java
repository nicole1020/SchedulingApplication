package Model;


import javafx.scene.control.DatePicker;
import java.time.LocalDateTime;


public class Appointments extends Customers {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String type;
    private LocalDateTime startDateTime;
    private LocalDateTime startTime;
    private DatePicker date;
    private LocalDateTime endTime;
    private LocalDateTime endDateTime;
    private int customerID;
    private int userID;


   /*public Appointments(int appointment_id, String title, String description, String location, int contact_id, String type, String start, String end, int customer_id, int user_id) {
        this.appointmentID = appointment_id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact_id;
        this.type = type;
        this.startDate = start;
        this.endDate = end;
        this.customerID = customer_id;
        this.userID = user_id;
    }**/

 

    public Appointments(int appointment_id, String title, String description, String location, int contact_id, String type, LocalDateTime start, LocalDateTime end, int customer_id, int user_id) {
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


    public DatePicker getDate() {
        return date;
    }




    public Appointments() {

    }

    @Override
    public int getCustomerID() {
        return customerID;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }


    public int getAppointmentID() {
        return appointmentID;}



    public String getTitle() {
        return title;}

    public String getDescription() {
        return description;}

    public String getLocation() {
        return location;}

    public int getContact() {
        return contact;}

    public String getType() {
        return type;}

    public LocalDateTime getStartDate() {
        return startDateTime;}

    public LocalDateTime getEndDateTime() {
        return endDateTime;}


    public int getUserID() {
        return userID;}



    public String toString() {
        return (type);
    }


}

