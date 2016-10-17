package ru.maxmetel.pair_reminder.main.model;

import java.util.List;

public class Day {
    private List<Subject> subjects;

    public Day(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
