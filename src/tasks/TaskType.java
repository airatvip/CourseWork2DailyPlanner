package tasks;

public enum TaskType {
    PERSONAL("Личная"),
    WORKING("Рабочая");
    private String translationType;

    TaskType(String translationType) {
        this.translationType = translationType;
    }

    public String getTranslationType() {
        return translationType;
    }
}
