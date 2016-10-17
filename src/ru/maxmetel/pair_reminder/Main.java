package ru.maxmetel.pair_reminder;

import java.io.IOException;
import java.util.List;

import ru.maxmetel.pair_reminder.model.Day;
import ru.maxmetel.pair_reminder.model.Group;
import ru.maxmetel.pair_reminder.model.OmstuGroups;
import ru.maxmetel.pair_reminder.model.OmstuSchedule;
import ru.maxmetel.pair_reminder.model.Subject;
import ru.maxmetel.pair_reminder.network.OmstuPwner;
import ru.maxmetel.pair_reminder.network.ScheduleQuery;
import ru.maxmetel.pair_reminder.parser.Parser;

public class Main {
	public static void main(String[] args) {
		OmstuPwner pwner = new OmstuPwner();
		ScheduleQuery query = new ScheduleQuery("Информационных технологий и компьютерных систем", 3);
		OmstuGroups groups = pwner.getGroups(query);
		for (Group group : groups.getList()) {
			System.out.println(group.getGroupOid() + ": " + group.getNumber());
		}
		query = new ScheduleQuery("Информационных технологий и компьютерных систем", 3, 444);
		OmstuSchedule sched = pwner.getSchedule(query);
		try {
			for (Day day : Parser.parse(sched.getHTML())) {
				System.out.println(day.getDate().toString());
				for (Subject subj : day.getSubjects()) {
					System.out.println(subj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
