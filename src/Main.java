import tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Задачи для проверки
//        Planner.addTask(new WeeklyTask("бег", "бег по лесу", LocalDateTime.parse("02.12.2022 10.10", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.PERSONAL, RepeatType.WEEKLY));
//        Planner.addTask(new MonthlyTask("бег", "бег по лесу трусцой", LocalDateTime.parse("10.10.2020 10.10", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.PERSONAL, RepeatType.MONTHLY));
//        Planner.addTask(new DailyTask("ходьба", "быстрый шаг 50 минут", LocalDateTime.parse("11.10.2020 12.50", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.PERSONAL, RepeatType.DAILY));
//        Planner.addTask(new DailyTask("обед", "легкий перекус", LocalDateTime.parse("11.10.2020 12.00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.PERSONAL, RepeatType.DAILY));
//        Planner.addTask(new SingleTask("съездить в КРНУ", "забрать бумаги в бухгалтерии", LocalDateTime.parse("12.10.2020 15.10", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.WORKING, RepeatType.SINGLE));
//        Planner.addTask(new SingleTask("ТО", "фильтр, масло 5w-30 4л", LocalDateTime.parse("11.10.2020 15.10", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.WORKING, RepeatType.SINGLE));
//        Planner.addTask(new YearTask("в баню", "Сандуны", LocalDateTime.parse("31.12.2020 23.00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")), TaskType.WORKING, RepeatType.ANNUALLY));


        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    scanner.nextLine();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            System.out.println("Ввведите ID задачи");
                            int id = scanner.nextInt();
                            Planner.getTaskMap().remove(id);
                            System.out.println("Задача удалена");
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.println("Введите дату в формате дд.мм.гггг: ");
                            readTaskDate(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        LocalDateTime date = readTaskDateTime(scanner);
        System.out.print("Введите тип повторяемости задачи:\n");
        RepeatType repeatType = readTaskRepeatType(scanner);
        TaskType type = readTaskType(scanner);
        switch (repeatType) {
            case SINGLE:
                Planner.addTask(new SingleTask(title, description, date, type, repeatType));
                break;
            case DAILY:
                Planner.addTask(new DailyTask(title, description, date, type, repeatType));
                break;
            case WEEKLY:
                Planner.addTask(new WeeklyTask(title, description, date, type, repeatType));
                break;
            case MONTHLY:
                Planner.addTask(new MonthlyTask(title, description, date, type, repeatType));
                break;
            case ANNUALLY:
                Planner.addTask(new YearTask(title, description, date, type, repeatType));
                break;

        }
//        System.out.println(tasks.Planner.getTaskMap());
    }


    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }

    public static RepeatType readTaskRepeatType(Scanner scanner) {
        System.out.println(
                """     
                        1. Разовая
                        2. Ежедневная
                        3. Еженедельная
                        4. Ежемесячная
                        5. Ежегодная
                        """
        );
        while (true) {
            try {
                int taskRepeatTypeSelector = scanner.nextInt();
                switch (taskRepeatTypeSelector) {
                    case 1:
                        return RepeatType.SINGLE;
                    case 2:
                        return RepeatType.DAILY;
                    case 3:
                        return RepeatType.WEEKLY;
                    case 4:
                        return RepeatType.MONTHLY;
                    case 5:
                        return RepeatType.ANNUALLY;
                    default:
                        System.out.println("Выбран неправильный тип повторяемости задачи");
                }
            } catch (Exception e) {
                System.out.println("Выбран неправильный тип повторяемости задачи");
            }
            scanner.nextLine();
        }
    }

    public static LocalDateTime readTaskDateTime(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату и время выполнения задачи в формате дд.мм.гггг чч.мм: ");
                String dateTime = scanner.nextLine();
                return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm"));
            } catch (DateTimeParseException e) {
                System.out.println("Дата и время введены неправильно, повторите ввод");
            }
        }
    }

    public static TaskType readTaskType(Scanner scanner) {
        System.out.println(
                """     
                        Выберите тип задачи:
                        1. Личная
                        2. Рабочая
                        """
        );
        while (true) {
            try {
                int taskType = scanner.nextInt();
                switch (taskType) {
                    case 1:
                        return TaskType.PERSONAL;
                    case 2:
                        return TaskType.WORKING;
                    default:
                        System.out.println("Введен неправильный тип задачи");
                }
            } catch (Exception e) {
                System.out.println("Введен неправильный тип задачи. Повторите ввод: ");
            }
            scanner.nextLine();
        }
    }

    public static void readTaskDate(Scanner scanner) {
        while (true) {
            try {
                String date = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                Planner.getTaskForDay(localDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Дата введена неправильно, повторите ввод");
            }
        }
    }


}
