package ru.maxmetel.pair_reminder.main.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subject {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");

    private Date date;
    private String subjectName;
    private String teacher;
    private String room;
    private String group;

    public Subject(String date, String startTime, String endTime, String subjectName, String teacher, String room, String group) {
        try {
            setDate(date, startTime, endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.room = room;
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date, String startTime, String endTime) {
        this.date = date;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
