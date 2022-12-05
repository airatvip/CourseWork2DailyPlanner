package tasks;

public enum RepeatType {
    SINGLE("Одноразовая"),
    DAILY("Ежедневная"),
    WEEKLY("Еженедельная"),
    MONTHLY("Ежемесячная"),
    ANNUALLY("Ежегодная");

    private String translationRepeat;

    RepeatType(String translationRepeat) {
        this.translationRepeat = translationRepeat;
    }

    public String getTranslationRepeat() {
        return translationRepeat;
    }
}
