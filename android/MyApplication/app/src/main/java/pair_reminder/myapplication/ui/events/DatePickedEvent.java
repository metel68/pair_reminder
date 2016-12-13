package pair_reminder.myapplication.ui.events;

public class DatePickedEvent {
    private String date;

    public DatePickedEvent(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
