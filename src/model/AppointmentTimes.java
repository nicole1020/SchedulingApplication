package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalTime;
import java.time.ZoneId;

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
        /*    ZoneId timeDifference = ZoneId.systemDefault();
        if (timeDifference == ZoneId.of("EST")) {
        if (timeDifference == ZoneId.of("GMT")) {
                for (int i = 8; i < 22; i++) {

                    appointmentTime.add(LocalTime.of(i, 0));
                    appointmentTime.add(LocalTime.of(i, 15));
                    appointmentTime.add(LocalTime.of(i, 30));
                    appointmentTime.add(LocalTime.of(i, 45));




                }
                if (timeDifference == ZoneId.of("CST")) {

                    for (int i = 7; i < 21; i++) {

                        appointmentTime.add(LocalTime.of(i, 0));
                        appointmentTime.add(LocalTime.of(i, 15));
                        appointmentTime.add(LocalTime.of(i, 30));
                        appointmentTime.add(LocalTime.of(i, 45));

                    }
                    if (timeDifference == ZoneId.of("PST")) {

                        for (int i = 9; i < 23; i++) {

                            appointmentTime.add(LocalTime.of(i, 0));
                            appointmentTime.add(LocalTime.of(i, 15));
                            appointmentTime.add(LocalTime.of(i, 30));
                            appointmentTime.add(LocalTime.of(i, 45));

                        }
                    }
                }
            }
        }**/

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
