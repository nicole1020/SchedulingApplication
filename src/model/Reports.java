package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Month;

public class Reports extends Appointments{

    private Month month;
    private String type;
    private int monthNumber;
    private String monthName;
    private int appointmentIDVerify;

    public Reports(String type, Month Month, int monthNumber, String monthName, int appointmentIDVerify){
        this.type = type;
        this.month = Month;
        this.monthNumber = monthNumber;
        this.monthName = monthName;
        this.appointmentIDVerify = appointmentIDVerify;
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

    public Month getMonth() {
        return month;
    }
    public String getType(){return type;
    }
    public int getAppointmentIDVerify(){return appointmentIDVerify;}
    public int getMonthNumber(){return monthNumber;    }
    public String getMonthName(){return monthName;}


}
