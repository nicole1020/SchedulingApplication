package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjuster;

public class AppointmentTimes extends Appointments {
    public static ObservableList<LocalTime> getAllAppointmentTimes() {
        ObservableList<LocalTime> appointmentTime = FXCollections.observableArrayList();


        for (int i = 0; i < 24; i++) {

            appointmentTime.add(LocalTime.of(i, 0));
            appointmentTime.add(LocalTime.of(i, 15));
            appointmentTime.add(LocalTime.of(i, 30));
            appointmentTime.add(LocalTime.of(i, 45));
            if (i == 23) {
                appointmentTime.add(LocalTime.of(i, 0));
                appointmentTime.add(LocalTime.of(i, 15));
                appointmentTime.add(LocalTime.of(i, 30));
                appointmentTime.add(LocalTime.of(i, 45));
                // System.out.println(LocalTime.of(i,0));
            }
        }
        return appointmentTime;
    }

    public static  ObservableList<LocalTime>  getAllEndTimes(LocalTime start) {
        ObservableList<LocalTime> endTime = FXCollections.observableArrayList();
        LocalTime end = start.plusMinutes(15);
        for (int i = end.getHour() ; i < 24; i++ ) {

            endTime.add(LocalTime.of(i, 0));
            endTime.add(LocalTime.of(i, 15));
            endTime.add(LocalTime.of(i, 30));
            endTime.add(LocalTime.of(i, 45));

            if (i == 23) {
                endTime.add(LocalTime.of(i, 0));
                endTime.add(LocalTime.of(i, 15));
                endTime.add(LocalTime.of(i, 30));
                endTime.add(LocalTime.of(i, 45));

                // System.out.println(LocalTime.of(i,0));
            }
        }
        for (LocalTime et : endTime)
            System.out.println(et);


        return endTime;
    }
}
