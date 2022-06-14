package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

import static DAO.DBConnection.connection;

public class ReportsHelper {

    public static ObservableList<Object> getReportsDataSortByType(Object m) {
        ObservableList<Object> reportsDataSortByTypeList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID ";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {

                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                Object Type = aResult.getObject("Type", (Map<String, Class<?>>) m);
                Month Start = aResult.getTimestamp("Start").toLocalDateTime().getMonth();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");
               reportsDataSortByTypeList.add(Type);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByTypeList;
    }

    public static ObservableList<Object> getReportsDataSortByMonth() {

        ObservableList<Object> reportsDataSortByMonthList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID  ORDER BY MONTH(Start)";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {

                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                String Start = aResult.getTimestamp("Start").toLocalDateTime().getMonth().toString();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");
                System.out.println("THIS HERE");
                reportsDataSortByMonthList.add(Start);
                // System.out.println(ap);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByMonthList;
    }
}
