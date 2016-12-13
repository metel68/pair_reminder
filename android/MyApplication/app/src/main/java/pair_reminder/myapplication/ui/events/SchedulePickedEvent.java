package pair_reminder.myapplication.ui.events;


public class SchedulePickedEvent {
    private String date;
    private String group;

    public SchedulePickedEvent(String date, String group) {
        this.date = date;
        this.group = group;
    }

    public String getDate() {
        return date;
    }

    public String getGroup() {
        return group;
    }
}
