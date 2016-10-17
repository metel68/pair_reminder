package ru.maxmetel.pair_reminder.main.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Day {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.mm.yyyy");

    private Date date;
    private List<Subject> subjects;

    public Day(String date, List<Subject> subjects) {
        try {
            setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.subjects = subjects;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = DATE_FORMAT.parse(date);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
