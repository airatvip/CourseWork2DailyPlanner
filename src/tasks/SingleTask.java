package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task {


    public SingleTask(String title, String description, LocalDateTime date, TaskType type, RepeatType repeatType) {
        super(title, description, date, type, repeatType);
    }

    @Override
    public boolean findIn(LocalDate localDate) {
        return this.getDate().toLocalDate().equals(localDate);
    }
}
