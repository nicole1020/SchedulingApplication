package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.time.*;
/**
 *
 * @author Nicole Mau
 * Initializing AppointmentTimes Class extends Appointments
 */


public class AppointmentTimes extends Appointments {

    LocalTime start;
    LocalTime end;
    LocalDate date;
    LocalTime startSoon;

    /**
     *
     * @param start start time for appointment
     * @param end end time for appointment
     * @param date date of appointment
     *
     */
    public AppointmentTimes(LocalTime start, LocalTime end, LocalDate date) {

        this.start = start;
        this.end = end;
        this.date = date;

    }

    /**
     *
     * @param isStart Initializing ObservableList<LocalTime> getAllAppointmentTimes to make sure user time and server time unite
     *
     * @return appointment time in user's timezone.
     */
    public static ObservableList<LocalTime> getAllAppointmentTimes(boolean isStart) {

        LocalDateTime estStart = LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0));
        ZonedDateTime estZoned = estStart.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime localZoned = estZoned.withZoneSameInstant(ZoneId.systemDefault());
        LocalTime localStart = localZoned.toLocalTime();

        LocalDateTime estEnd = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 0));
        ZonedDateTime estEndZoned = estEnd.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime localEndZoned = estEndZoned.withZoneSameInstant(ZoneId.systemDefault());
        LocalTime localEnd = localEndZoned.toLocalTime();

        ObservableList<LocalTime> appointmentTime = FXCollections.observableArrayList();

        LocalTime start = localStart;
        LocalTime end = localEnd;

        if (!isStart) {
            start = start.plusMinutes(15);
            end = end.plusMinutes(15);
        }


        while (start.isBefore(end)) {
            appointmentTime.add(start);
            start = start.plusMinutes(15);
        }

        return appointmentTime;
    }
}


