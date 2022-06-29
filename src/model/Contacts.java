package model;
/**
 *
 * @author Nicole Mau
 *  Initializing Contacts Class extends Appointments
 */

public class Contacts extends Appointments {
    private int contactID;
    private String contactName;
    private String email;

    /**
     * @param contact_id   contact's contact id number
     * @param contact_Name contact's full name
     * @param email        contact's email address
     */
    public Contacts(Integer contact_id, String contact_Name, String email) {
        this.contactID = contact_id;
        this.contactName = contact_Name;
        this.email = email;
    }

    /**
     * @param contact_id contact id number
     */
    public Contacts(Integer contact_id) {
        this.contactID = contact_id;
    }

    public Contacts(Integer contactids, String contactnames) {
        this.contactID = contactids;
        this.contactName = contactnames;
    }

    /**
     * @return contact's contact id number
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * @return contacts's full name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @return contact's email name
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return contactID and    contactName  in combo box for contacts
     */
    @Override
    public String toString() {
        return ( "["+contactID +"]" + contactName );
    }

}