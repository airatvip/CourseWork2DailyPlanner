package tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Planner {
    private static Map<Integer, Task> taskMap = new HashMap<>();

    public static Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public static void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public static void getTaskForDay(LocalDate localDate) {
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskMap.values()) {
            if (task.findIn(localDate)) {
                tasks.add(task);

            }

        }
        System.out.println(tasks);

    }
}
