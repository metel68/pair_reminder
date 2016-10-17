package ru.maxmetel.pair_reminder.main.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import ru.maxmetel.pair_reminder.main.model.OmstuGroups;
import ru.maxmetel.pair_reminder.main.model.OmstuSchedule;

public class OmstuPwner {
	String url = "http://omgtu.ru/students/temp/ajax.php";
	String charset = java.nio.charset.StandardCharsets.UTF_8.name();
	Gson gson = new Gson();

	public Object getResponse(ScheduleQuery query, ScheduleActions action, Class<?> klass) {
		InputStream response;
		try {
			response = this.fireRequest(action, query);
			JsonReader reader = new JsonReader(new InputStreamReader(response, "UTF-8"));
			Object answer = gson.fromJson(reader, klass);
			reader.close();
			return answer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public OmstuGroups getGroups(ScheduleQuery query) {
		return (OmstuGroups) getResponse(query, ScheduleActions.get_groups, OmstuGroups.class);
	}

	public OmstuSchedule getSchedule(ScheduleQuery query) {
		return (OmstuSchedule) getResponse(query, ScheduleActions.get_schedule, OmstuSchedule.class);
	}

	public InputStream fireRequest(ScheduleActions action, ScheduleQuery query)
			throws MalformedURLException, IOException {
		String queryString = String.format("?action=%s", action);
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
