package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {


    public DailyTask(String title, String description, LocalDateTime date, TaskType type, RepeatType repeatType) {
        super(title, description, date, type, repeatType);
    }


    @Override
    public boolean findIn (LocalDate localDate) {
        return this.getDate().toLocalDate().equals(localDate) || this.getDate().toLocalDate().isBefore(localDate);
    }
}
