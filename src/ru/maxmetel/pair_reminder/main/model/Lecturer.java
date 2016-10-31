package ru.maxmetel.pair_reminder.main.model;

public class Lecturer {

	String chair;
	Integer chairOid;
	String fio;
	String shortFIO;
	Integer lecturerOid;

	public Lecturer(Integer lecturerOid, String fio) {
		super();
		this.fio = fio;
		this.lecturerOid = lecturerOid;
	}
	public String getChair() {
		return chair;
	}
	public Integer getChairOid() {
		return chairOid;
	}
	public String getFio() {
		return fio;
	}
	public String getShortFIO() {
		return shortFIO;
	}
	public Integer getLecturerOid() {
		return lecturerOid;
	}
}
