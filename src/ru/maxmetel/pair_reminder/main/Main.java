package ru.maxmetel.pair_reminder.main;

import java.io.IOException;

import ru.maxmetel.pair_reminder.main.model.Day;
import ru.maxmetel.pair_reminder.main.model.Group;
import ru.maxmetel.pair_reminder.main.model.OmstuGroups;
import ru.maxmetel.pair_reminder.main.model.OmstuSchedule;
import ru.maxmetel.pair_reminder.main.model.Subject;
import ru.maxmetel.pair_reminder.main.network.OmstuPwner;
import ru.maxmetel.pair_reminder.main.network.ScheduleQuery;
import ru.maxmetel.pair_reminder.main.parser.Parser;

public class Main {
	public static void main(String[] args) {
		OmstuPwner pwner = new OmstuPwner();
		ScheduleQuery query = new ScheduleQuery("�������������� ���������� � ������������ ������", 3);
		OmstuGroups groups = pwner.getGroups(query);
		for (Group group : groups.getList()) {
			System.out.println(group.getGroupOid() + ": " + group.getNumber());
		}
		query = new ScheduleQuery("�������������� ���������� � ������������ ������", 3, 444);
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
