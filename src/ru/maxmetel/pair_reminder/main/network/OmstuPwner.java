package ru.maxmetel.pair_reminder.main.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import ru.maxmetel.pair_reminder.main.model.Day;
import ru.maxmetel.pair_reminder.main.model.DumbLecturer;
import ru.maxmetel.pair_reminder.main.model.Group;
import ru.maxmetel.pair_reminder.main.model.Lecturer;
import ru.maxmetel.pair_reminder.main.model.ListAnswer;
import ru.maxmetel.pair_reminder.main.model.OmstuError;
import ru.maxmetel.pair_reminder.main.model.OmstuSchedule;
import ru.maxmetel.pair_reminder.main.parser.Parser;

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
	
	public ListAnswer<String> getFaculties() {
		String baseUri = "http://omgtu.ru/students/temp/";
		String charset = "windows-1251";
		List<String> faculties = new ArrayList<>();
		try {
			InputStream stream = this.fireRequest(ScheduleActions.empty, new ScheduleQuery(), baseUri);
			faculties = Parser.parseFaculties(stream, charset, baseUri);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ListAnswer<String>(faculties, true, new OmstuError());
	}

	public ListAnswer<Group> getGroups(ScheduleQuery query) {
		Type ansType = new TypeToken<ListAnswer<Group>>() {
		}.getType();
		return (ListAnswer<Group>) getResponse(query, ScheduleActions.get_groups, ansType);
	}

	public ListAnswer<Day> getSchedule(ScheduleQuery query) throws IOException {
		OmstuSchedule raw = (OmstuSchedule) getResponse(query, ScheduleActions.get_schedule, OmstuSchedule.class);
		List<Day> schedule = new ArrayList<>();
		for (Day day : Parser.parseSchedule(raw.getHTML())) {
			schedule.add(day);
		}
		return new ListAnswer<Day>(schedule, true, new OmstuError());
	}

	public ListAnswer<Lecturer> getLecturers(char letter) {
		Type ansType = new TypeToken<ListAnswer<Lecturer>>() {
		}.getType();
		return (ListAnswer<Lecturer>) getResponse(new ScheduleQuery(),
				ScheduleActions.get_lecturers.getLecturers(letter), ansType);
	}

	public ListAnswer<Lecturer> getLecturers(String name) {
		Type ansType = new TypeToken<List<DumbLecturer>>() {
		}.getType();
		List<DumbLecturer> dumbs = (List<DumbLecturer>) getResponse(new ScheduleQuery(),
				ScheduleActions.lecturer_autocomplete.getLecturers(name), ansType);
		List<Lecturer> list;
		list = dumbs.stream().map((dumb) -> dumb.asLecturer()).collect(Collectors.toList());
		return new ListAnswer<Lecturer>(list, true, new OmstuError());
	}
	
	public InputStream fireRequest(ScheduleActions action, ScheduleQuery query)
			throws MalformedURLException, IOException {
		return this.fireRequest(action, query, this.url);
	}

	public InputStream fireRequest(ScheduleActions action, ScheduleQuery query, String url)
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
