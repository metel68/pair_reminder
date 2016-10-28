package ru.maxmetel.pair_reminder.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import ru.maxmetel.pair_reminder.model.Group;
import ru.maxmetel.pair_reminder.model.Lecturer;
import ru.maxmetel.pair_reminder.model.ListAnswer;
import ru.maxmetel.pair_reminder.model.OmstuSchedule;

public class OmstuPwner {
	String url = "http://omgtu.ru/students/temp/ajax.php";
	String charset = java.nio.charset.StandardCharsets.UTF_8.name();
	Gson gson = new Gson();

	public Object getResponse(ScheduleQuery query, ScheduleActions action, Type type) {
		InputStream response;
		try {
			response = this.fireRequest(action, query);
			JsonReader reader = new JsonReader(new InputStreamReader(response, "UTF-8"));
			Object answer = gson.fromJson(reader, type);
			reader.close();
			return answer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ListAnswer<Group> getGroups(ScheduleQuery query) {
		Type ansType = new TypeToken<ListAnswer<Group>>(){}.getType();
		return (ListAnswer<Group>) getResponse(query, ScheduleActions.get_groups, ansType);
	}

	public OmstuSchedule getSchedule(ScheduleQuery query) {
		return (OmstuSchedule) getResponse(query, ScheduleActions.get_schedule, OmstuSchedule.class);
	}
	
	public ListAnswer<Lecturer> getLecturers() {
		Type listType = new TypeToken<ArrayList<Lecturer>>(){}.getType();
		return (ListAnswer<Lecturer>) getResponse(new ScheduleQuery(), ScheduleActions.get_lecturers.getLecturers("П"), 
				ListAnswer.class);
	}

	public InputStream fireRequest(ScheduleActions action, ScheduleQuery query)
			throws MalformedURLException, IOException {
		String queryString = action.toString();
		HttpURLConnection connection = null;
		connection = (HttpURLConnection) new URL(url + queryString).openConnection();
		connection.setDoOutput(true); // Triggers POST.
		connection.setRequestProperty("Accept-Charset", charset);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		System.out.println(query.toString());
		try (OutputStream output = connection.getOutputStream()) {
			output.write(query.toString().getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(connection.getResponseCode());
		InputStream response = connection.getInputStream();
		return response;
	}
}
