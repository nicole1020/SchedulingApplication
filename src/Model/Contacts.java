package Model;

public class Contacts extends Appointments{
    private int contactID;
    private String contactName;
    private String email;

    public Contacts(Integer contact_id, String contact_Name, String email) {
        this.contactID = contact_id;
        this.contactName = contact_Name;
        this.email = email;
    }

    public int getContactID() {
        return contactID;
    }




    public String getContactName() {
        return contactName;
    }

    public String getEmail() {
        return email;
    }


}