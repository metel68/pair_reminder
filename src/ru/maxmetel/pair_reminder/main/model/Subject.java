package ru.maxmetel.pair_reminder.main.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "subjects")
public class Subject {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column
    private String subjectName;
    @Column
    private String teacher;
    @Column
    private String room;
    @Column(name = "subject_group")
    private String group;

    public Subject(String date, String startTime, String endTime, String subjectName,
                   String teacher, String room, String group) {
        this(0, date, startTime, endTime, subjectName, teacher, room, group);
    }

    public Subject(int id, String date, String startTime, String endTime, String subjectName,
                   String teacher, String room, String group) {
        this.id = id;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.room = room;
        this.group = group;
        try {
            setStartTime(date, startTime);
            setEndTime(date, endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(String date, String startTime) throws ParseException {
        String time = date + " " + startTime;
        this.startTime = DATE_FORMAT.parse(time);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(String date, String endTime) throws ParseException {
        String time = date + " " + endTime;
        this.endTime = DATE_FORMAT.parse(time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
	public String toString() {
		return String.format("%s-%s, %s, %s, %s, %s]",
				startTime, endTime, subjectName, teacher, room, group);
	}
}
