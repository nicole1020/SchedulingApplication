package Model;


import javafx.scene.control.DatePicker;

import java.time.LocalDateTime;
import java.util.Date;

public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String type;
    private String startDate;
    private LocalDateTime startTime;
    private DatePicker date;
    private LocalDateTime endTime;
    private String endDate;
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

    public Appointments(String type) {
    }

    public Appointments(int appointment_id, String title, String description, String location, int contact_id, String type, String start, String end, int customer_id, int user_id) {
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
    }

    public DatePicker getDate() {
        return date;
    }

    public Appointments(Integer customer_id) {
        this.customerID = customer_id;}


    public Appointments() {

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

    public String getStartDate() {
        return startDate;}

    public String getEndDateTime() {
        return endDate;}

    public int getCustomerID() {
        return customerID;}

    public int getUserID() {
        return userID;}
}

