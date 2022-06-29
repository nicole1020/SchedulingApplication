package model;
/**
 *
 * @author Nicole Mau
 *  Initializing Contacts Class extends Appointments
 */

public class Contact extends Appointments {
    private int contactID;
    private String contactName;

    /**
     * @param contactids   contact's contact id number
     * @param contactnames contact's full name
     *
     */

      public Contact(Integer contactids, String contactnames) {
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

    /**
     * @return contactID and    contactName  in combo box for contacts
     */
    @Override
    public String toString() {
        return ( "["+contactID +"]" + contactName  );
    }

}