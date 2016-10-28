package ru.maxmetel.pair_reminder.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ScheduleQuery {
	private final Map<String,Object> params = new HashMap<String,Object>();
	
	public ScheduleQuery(boolean lecturerMode, int Oid) {
		this();
		if (lecturerMode) {
			params.put("filter[lecturerOid]", Oid);
		} else {
			params.put("filter[groupOid]", Oid);
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
