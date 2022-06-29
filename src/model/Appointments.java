package model;


import java.time.LocalDateTime;

/**
 *
 * @author Nicole Mau
 * Initializing Appointments Class extends Customers
 */



public class Appointments extends Customers {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contact;
    private String contactName;
    private String type;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int customerID;
    private int userID;

    /**
     *
     * @param appointment_id appointment id number
     * @param title appointment title
     * @param description appointment description
     * @param location appointment location
     * @param contact_id appointment contact_id
     * @param type appointment type
     * @param start appointment start time/date
     * @param end appointment end time/date
     * @param customer_id customer id of customer who's appointment it is
     * @param user_id user id who scheduled appointment
     */
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

    /**
     *
     * @param type type of appointment
     */
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

    public Appointments(LocalDateTime start, LocalDateTime end) {
        this.startDateTime = start;
        this.endDateTime = end;
    }




    /**
     *
     * @return  customer id of customer who's appointment it is
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return  contactName of customer who's appointment it is
     */

    public String getContactName() {

        return contactName;
    }

    /**
     *
     * @return  appointment id of appointment
     */
    public int getAppointmentID() {
        return appointmentID;
    }
    /**
     *
     * @return title of appointment
     */
    public String getTitle() {
        return title;
    }
    /**
     *
     * @return description of appointment
     */
    public String getDescription() {
        return description;
    }
    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }
    /**
     *
     * @return contactID of said appointment
     */
    public Integer getContact() {
        return contact;
    }
    /**
     *
     * @return type of appointment
     */
    public String getType() {
        return type;
    }
    /**
     *
     * @return start date/time
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    /**
     *
     * @return end date/time
     */
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    /**
     *
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return type to populate as a string instead of database location
     */
    @Override
    public String toString() {
        return (type);
    }


}

