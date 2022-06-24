package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.time.*;
/**
 *
 * @author Nicole Mau
 */

// initialize (start:LocalTime, end:LocalTime, date:LocalTime)
public class AppointmentTimes extends Appointments {

    LocalTime start;
    LocalTime end;
    LocalDate date;
    LocalTime startSoon;

    public AppointmentTimes(LocalTime start, LocalTime end, LocalDate date, LocalTime startSoon) {

        this.start = start;
        this.end = end;
        this.date = date;
        this.startSoon = startSoon;

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
        LocalTime startSoon = start.plusMinutes(15);

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

    public static ObservableList<LocalTime> getAppointmentSoonAlertCheck() {

        LocalDateTime userTime = LocalDateTime.now();
        ZonedDateTime userZone = userTime.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime userZoned = userZone.withZoneSameInstant(ZoneId.systemDefault());
        LocalTime userStart = userZoned.toLocalTime();
        LocalTime startSoon = userStart.plusMinutes(15);
        ObservableList<LocalTime> appointmentTimeAlert = FXCollections.observableArrayList();

        //Alerts user with popup if an appointment is within the next 15 minutes
        if(userStart.isBefore(startSoon)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING!");
            alert.setHeaderText("Appointment approaching within the next 15 minutes");

            alert.setContentText("Caution!");

            alert.showAndWait();

        }
        return appointmentTimeAlert;

    }
}

