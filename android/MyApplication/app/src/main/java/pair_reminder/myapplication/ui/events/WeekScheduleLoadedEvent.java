package pair_reminder.myapplication.ui.events;

import java.util.ArrayList;

import pair_reminder.myapplication.models.Subject;

public class WeekScheduleLoadedEvent {
    private ArrayList<Subject> subjects;

    public WeekScheduleLoadedEvent(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
