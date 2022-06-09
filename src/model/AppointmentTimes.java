package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class AppointmentTimes extends Appointments {
    public static ObservableList<LocalTime> getAllAppointmentTimes() {
        ObservableList<LocalTime> appointmentTime = FXCollections.observableArrayList();
        ZoneId timeDifference = ZoneId.systemDefault();
        if (timeDifference == ZoneId.ofOffset("GMT", ZoneOffset.ofHours(0))) {
            for (int i = 8; i < 22; i++) {

                appointmentTime.add(LocalTime.of(i, 0));
                appointmentTime.add(LocalTime.of(i, 15));
                appointmentTime.add(LocalTime.of(i, 30));
                appointmentTime.add(LocalTime.of(i, 45));

            }
            if (timeDifference == ZoneId.ofOffset("EST", ZoneOffset.ofHours(2))) {
                for (int i = 10; i < 24; i++) {

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
                if (timeDifference == ZoneId.ofOffset("CST", ZoneOffset.ofHours(-1))) {

                    for (int i = 7; i < 21; i++) {

                        appointmentTime.add(LocalTime.of(i, 0));
                        appointmentTime.add(LocalTime.of(i, 15));
                        appointmentTime.add(LocalTime.of(i, 30));
                        appointmentTime.add(LocalTime.of(i, 45));

                    }
                    if (timeDifference == ZoneId.ofOffset("PST", ZoneOffset.ofHours(1))) {

                        for (int i = 9; i < 23; i++) {

                            appointmentTime.add(LocalTime.of(i, 0));
                            appointmentTime.add(LocalTime.of(i, 15));
                            appointmentTime.add(LocalTime.of(i, 30));
                            appointmentTime.add(LocalTime.of(i, 45));

                        }
                    }
                }
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
