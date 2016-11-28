package ru.maxmetel.pair_reminder.main.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ScheduleQuery {
	private final Map<String, Object> params = new HashMap<String, Object>();
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	public ScheduleQuery(boolean lecturerMode, int Oid) {
		this();
		if (lecturerMode) {
			params.put("filter[lecturerOid]", Oid);
		} else {
			params.put("filter[groupOid]", Oid);
		}
	}

	public ScheduleQuery(boolean lecturerMode, int Oid, String date) {
		this(lecturerMode, Oid);
		Date dateParts;
		try {
			dateParts = DATE_FORMAT.parse(date);
			dateParts.setDate(dateParts.getDate());
			params.put("filter[fromDate]", DATE_FORMAT.format(dateParts));
			dateParts.setDate(dateParts.getDate()+1);
			params.put("filter[toDate]", DATE_FORMAT.format(dateParts));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public ScheduleQuery(String faculty, int course) {
		this(faculty);
		params.put("filter[course]", course);
	}

	public ScheduleQuery(String faculty) {
		super();
		params.put("filter[faculty]", faculty);
	}

	ScheduleQuery() {
		super();
	}

	@Override
	public String toString() {
		return UrlEncoder.urlEncodeUTF8(this.params);
	}

	private void putArgument(String key, Object value) {
		this.params.put(key, value);
	}
}
