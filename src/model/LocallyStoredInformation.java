package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LocallyStoredInformation {
  //appointment related information
    private static ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> getAllAppointments() {
        return allAppointments;
    }
    public static void addAppointment(Appointments newAppointment) {
        allAppointments.add(newAppointment);
    }
    //customer related information
    private static ObservableList<Customers> allCustomers = FXCollections.observableArrayList();

    private static ObservableList<Customers> allCustomerIDs = FXCollections.observableArrayList();
    public static void addCustomer(Customers newCustomer) {
        allCustomers.add(newCustomer);
    }
    public static Customers lookupCustomerID(int customerID) {
        return null;
    }
    public static Customers lookupAllCustomerIDs(int customerID){
        return (Customers) allCustomerIDs;
    }

    public static ObservableList<Customers> getAllCustomers() {
        return allCustomers;
    }
    //user related information
    private static ObservableList<User> allUserIDs = FXCollections.observableArrayList();
    public static User lookupAllUserIDs(int userID){
        return (User) allUserIDs;
    }




}
