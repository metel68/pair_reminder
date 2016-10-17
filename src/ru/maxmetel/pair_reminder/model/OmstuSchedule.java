package ru.maxmetel.pair_reminder.model;

import java.util.List;

public class OmstuSchedule {
	String html;
	Boolean success;
	OmstuError error;
	int count;

	public String getHTML() {
		return html;
	}
	public Boolean getSuccess() {
		return success;
	}
	public OmstuError getError() {
		return error;
	}
	public int getCount() {
		return count;
	}
}
