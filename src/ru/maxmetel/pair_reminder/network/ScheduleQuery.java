package ru.maxmetel.pair_reminder.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class ScheduleQuery {
	public ScheduleQuery(String faculty, int course, int groupOid) {
		super();
		this.faculty = faculty;
		this.course = course;
		this.groupOid = groupOid;
	}
	
	public ScheduleQuery(String faculty, int course) {
		super();
		this.faculty = faculty;
		this.course = course;
	}

	public ScheduleQuery(String faculty) {
		super();
		this.faculty = faculty;
	}
	
	String type = "g";
	String faculty = null;
	Integer course = null;
	Integer groupOid = null;
	Integer lecturerOid = null;
	Integer auditoriumOid = null;
	Date fromDate = null;
	Date toDate = null;

	private final String charset = java.nio.charset.StandardCharsets.UTF_8.name();

	@Override
	public String toString() {
		StringBuilder query = null;
		try {
			query = new StringBuilder("filter[type]=");
			query.append(URLEncoder.encode(type, charset));
			if (faculty != null) {
				query.append("&filter[faculty]=");
				query.append(URLEncoder.encode(faculty, charset));
			}
			if (course != null) {
				query.append("&filter[course]=");
				query.append(URLEncoder.encode(course.toString(), charset));
			}
			if (groupOid != null) {
				query.append("&filter[groupOid]=");
				query.append(URLEncoder.encode(groupOid.toString(), charset));
			}
			if (lecturerOid != null) {
				query.append("&filter[lecturerOid]=");
				query.append(URLEncoder.encode(lecturerOid.toString(), charset));
			}
			if (auditoriumOid != null) {
				query.append("&filter[auditoriumOid]=");
				query.append(URLEncoder.encode(auditoriumOid.toString(), charset));
			}
			if (fromDate != null) {
				query.append("&filter[fromDate]=");
				query.append(URLEncoder.encode(fromDate.toString(), charset));
			}
			if (toDate != null) {
				query.append("&filter[toDate]=");
				query.append(URLEncoder.encode(toDate.toString(), charset));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
		return query.toString();
	}
}
