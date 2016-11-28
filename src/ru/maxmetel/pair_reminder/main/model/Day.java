package ru.maxmetel.pair_reminder.main.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Day {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
    private List<Subject> subjects;
    private Date date;
    
    public Day(List<Subject> subjects, String day) throws ParseException {
        this.subjects = subjects;
        this.setDate(day);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date day) {
		this.date = day;
	}
	
	public void setDate(String day) throws ParseException {
        this.date = DATE_FORMAT.parse(day);
	}
}
