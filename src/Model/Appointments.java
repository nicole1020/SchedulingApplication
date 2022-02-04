package Model;


public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private String contact;
    private String type;
    private String startDateTime;
    private String endDateTime;
    private int customerID;
    private int userID;

    public Appointments(int appointmentID, String title, String description, String location, String contact, String type, String startDateTime, String endDateTime, int customerID, int userID) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customerID = customerID;
        this.userID = userID;

    }




    public Appointments(int appointment_id, String title, String description, String location, int contact_id, String type, String start, String end, int customer_id, int user_id) {
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

    public String getContact() {
        return contact;
    }

    public String getType() {
        return type;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getUserID() {
        return userID;
    }
}

