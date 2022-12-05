package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String title, String description, LocalDateTime date, TaskType type, RepeatType repeatType) {
        super(title, description, date, type, repeatType);
    }
    @Override
    public boolean findIn (LocalDate localDate) {
        return this.getDate().toLocalDate().equals(localDate) || this.getDate().toLocalDate().isBefore(localDate) && this.getDate().toLocalDate().getDayOfMonth()==localDate.getDayOfMonth();
    }
}
