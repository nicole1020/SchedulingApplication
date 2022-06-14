package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Reports;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.Month;


import static DAO.DBConnection.connection;


public class ReportsHelper {


    public static ObservableList<String> getReportsDataSortByType() {
        ObservableList<String> reportsDataSortByTypeList = FXCollections.observableArrayList();
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
                String Type = aResult.getString("Type");
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

    public static <Alert> ObservableList<Month> getReportsDataSortByMonth() {

        ObservableList<Month> reportsDataSortByMonthList = FXCollections.observableArrayList();

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
                Month Start = aResult.getTimestamp("Start").toLocalDateTime().getMonth();
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

    public static ObservableList<Reports> getDataSortByMonthAndType(String typeValue, Month monthValue) throws SQLException {
        ObservableList<Reports> dataSortByMonthAndTypeList = FXCollections.observableArrayList();
        String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID  ORDER BY MONTH(Start)";
        PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
        ResultSet aResult = prepA.executeQuery();
        while (aResult.next()) {
            String type = aResult.getString("Type");
            Month month = aResult.getTimestamp("Start").toLocalDateTime().getMonth();
       Reports nR = new Reports(typeValue, monthValue);
            dataSortByMonthAndTypeList.add(nR);

        }
        return dataSortByMonthAndTypeList;
    }
}
