package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalTime;

public class AppointmentTimes {
    public static ObservableList<LocalTime> startTimes() {
        ObservableList<LocalTime> startTime = FXCollections.observableArrayList();

        LocalTime start = LocalTime.of(0, 0);
        for (int i = 0; i < 24; i++) {

            startTime.add(LocalTime.of(i, 0));
            startTime.add(LocalTime.of(i, 15));
            startTime.add(LocalTime.of(i, 30));
            startTime.add(LocalTime.of(i, 45));
            if (i == 23) {
                startTime.add(LocalTime.of(i, 0));
                startTime.add(LocalTime.of(i, 15));
                startTime.add(LocalTime.of(i, 30));
                startTime.add(LocalTime.of(i, 45));
                // System.out.println(LocalTime.of(i,0));
            }
        }
        return startTime;
    }

    public static  ObservableList<LocalTime>  endTimes() {
        ObservableList<LocalTime> endTime = FXCollections.observableArrayList();
        LocalTime end = LocalTime.of(0, 0);
        for (int i = 0; i < 24; i++) {

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
