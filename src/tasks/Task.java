package tasks;

import java.time.LocalDateTime;
import java.util.Objects;

;

public abstract class Task implements FindIn {
    private static int count;
    private int id;
    private String title;
    private String description;
    private LocalDateTime date;
    private TaskType type;

    private RepeatType repeatType;


    public Task(String title, String description, LocalDateTime date, TaskType type, RepeatType repeatType) {
        this.id = count++;
        setTitle(title);
        setDescription(description);
        this.date = date;
        this.type = type;
        this.repeatType = repeatType;
    }

    public static int getCount() {
        return count;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty() || title.isBlank()) {
            title = "Нет заголовка";
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty() || description.isBlank()) {
            description = "Нет описания";
        }
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;

    }

//    public TaskType getType() {
//        return type;
//    }
//
//    public void setType(TaskType type) {
//        this.type = type;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(date, task.date) && type == task.type && repeatType == task.repeatType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, type, repeatType);
    }

    @Override
    public String toString() {
        return "ID = " + id + ";" +
                " Дата - " + date + ";" +
                " Заголовок - " + title + ";" +
                " Описание - " + description + ";" +
                " Тип - " + type.getTranslationType() + ";" +
                " Повторяемость - " + repeatType.getTranslationRepeat() + "\n";

    }
}
