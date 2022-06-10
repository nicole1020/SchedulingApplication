package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;


public class AppointmentTimes extends Appointments {
     LocalTime start;
    LocalTime end;

    public AppointmentTimes(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

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
