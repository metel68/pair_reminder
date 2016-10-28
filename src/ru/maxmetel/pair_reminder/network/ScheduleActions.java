package ru.maxmetel.pair_reminder.network;

import java.util.HashMap;
import java.util.Map;

public enum ScheduleActions {
	get_schedule, get_groups, get_lecturers;
	
	private final Map<String,Object> params = new HashMap<>();
	
	public ScheduleActions getLecturers(String letter) {
		this.params.put("letter", letter);
		return this;
	}
	
	@Override
	public String toString() {
		if (this.params.isEmpty()) {
			return String.format("?action=%s", this.name());
		} else {
			return String.format("?action=%s&%s", this.name(),UrlEncoder.urlEncodeUTF8(params));
		}
	}
}
