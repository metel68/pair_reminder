package ru.maxmetel.pair_reminder.main.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.maxmetel.pair_reminder.main.model.Day;
import ru.maxmetel.pair_reminder.main.model.Subject;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    static public List<Day> parseSchedule(String html) throws IOException {
        List<Day> days = new ArrayList<>();

        Day day;
        Subject subject;

        String date;

        String[] time;
        String startTime;
        String endTime;
        String subjectName;
        String teacher;
        String room;
        String group;

        Document doc = Jsoup.parse(html);

        Elements tables = doc.select("table");
        for (Element table : tables) {
            Elements rows = table.select("tr");

            date = rows.get(0).text().split(", ")[1];
            List<Subject> subjects = new ArrayList<>();

            for (int j = 2; j < rows.size(); j++) {
                Element row = rows.get(j);
                Elements cols = row.select("td");
                Element timeColumn = cols.get(0);
                Element otherInfoColumn = cols.get(1);

                time = timeColumn.text().split(" - ");
                startTime = time[0];
                endTime = time[1];

                String text = otherInfoColumn.html();
                String[] textSplitResult = text.split("<br>");

                subjectName = textSplitResult[0].trim();
                teacher = textSplitResult[1].trim();
                room = textSplitResult[2].trim();
                group = textSplitResult[3].trim();

                
                try {
					subject = new Subject(date, startTime, endTime, subjectName, teacher, room, group);
	                subjects.add(subject);
				} catch (ParseException e) {
					e.printStackTrace();
				}
            }
            try {
				day = new Day(subjects, date);
				days.add(day);
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        return days;
    }
    static public List<String> parseFaculties(InputStream html, String charsetName, String baseUri)
    throws IOException {
        List<String> out = new ArrayList<>();

        Document doc = Jsoup.parse(html, charsetName, baseUri);

        Elements faculties = doc.select("#faculty_list").select("option");
        for (Element faculty : faculties) {             
        	out.add(faculty.val());
        }
        return out;
    }
}



