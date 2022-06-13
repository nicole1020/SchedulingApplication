package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.Month;

public class Reports extends Appointments{

    private String month;
    private int appointmentID;

    public Reports(int appointment_ID, String Month){
        this.appointmentID = appointment_ID;
        this.month = Month;
    }

    public static ObservableList <Month> getAllMonths(){
    ObservableList<Month> allMonthsList = FXCollections.observableArrayList();
    Month January  = Month.of(1);
    Month February = Month.of(2);
    Month March = Month.of(3);
    Month April = Month.of(4);
    Month May = Month.of(5);
    Month June  = Month.of(6);
    Month July = Month.of(7);
    Month August = Month.of(8);
    Month September = Month.of(9);
    Month October = Month.of(10);
    Month November  = Month.of(11);
    Month December = Month.of(12);
        allMonthsList.addAll(January, February, March, April, May, June, July, August, September, October, November, December);
    return allMonthsList;
}

    public String getMonth() {
        return month;
    }


}
