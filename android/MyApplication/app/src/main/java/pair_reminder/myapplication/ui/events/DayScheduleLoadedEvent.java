package pair_reminder.myapplication.ui.events;

import java.util.ArrayList;

import pair_reminder.myapplication.models.Subject;

public class DayScheduleLoadedEvent {
    private ArrayList<Subject> subjects;

    public DayScheduleLoadedEvent(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
