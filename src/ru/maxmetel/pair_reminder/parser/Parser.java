import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    static public List<Day> parse(String html) throws IOException {
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

                subject = new Subject(startTime, endTime, subjectName, teacher, room, group);
                subjects.add(subject);
            }
            day = new Day(date, subjects);
            days.add(day);
        }
        return days;
    }
}



