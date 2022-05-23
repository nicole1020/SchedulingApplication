package Model;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class StartTime extends Appointments{
private LocalDateTime startDate;
    public StartTime(LocalDateTime date) {
        this.startDate = date;

    }
    public LocalDateTime getStartDate(){
        return startDate;
    }
}
