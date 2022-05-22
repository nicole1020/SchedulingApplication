package Model;


import java.time.LocalTime;

public class StartTime extends Appointments{
private LocalTime startDate;
    public StartTime(LocalTime date) {
        this.startDate = date;

    }
    public LocalTime getStartDate(){
        return startDate;
    }
}
