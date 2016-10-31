package ru.maxmetel.pair_reminder.main.model;

public class DumbLecturer {
	String value;
	int id;
	
	public Lecturer asLecturer() {
		return new Lecturer(id, value);
	}
}
