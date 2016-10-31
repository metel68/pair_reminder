package ru.maxmetel.pair_reminder.main;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import ru.maxmetel.pair_reminder.main.model.Day;
import ru.maxmetel.pair_reminder.main.model.Group;
import ru.maxmetel.pair_reminder.main.model.Lecturer;
import ru.maxmetel.pair_reminder.main.model.ListAnswer;
import ru.maxmetel.pair_reminder.main.model.OmstuSchedule;
import ru.maxmetel.pair_reminder.main.model.Subject;
import ru.maxmetel.pair_reminder.main.network.OmstuPwner;
import ru.maxmetel.pair_reminder.main.network.ScheduleQuery;
import ru.maxmetel.pair_reminder.main.parser.Parser;

public class Main {
	public static void main(String[] args) {
		System.out.println();
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
		JarseyConfig jerseyConfig = new JarseyConfig();
		//ConfigReader.getProperties();
		//Messages.init();
		Server server = JettyHttpContainerFactory.createServer(baseUri, jerseyConfig);
	}
	
	private static void demo() {
		OmstuPwner pwner = new OmstuPwner();
		ScheduleQuery query = new ScheduleQuery("Информационных технологий и компьютерных систем", 3);
		ListAnswer<Group> groups = pwner.getGroups(query);
		for (Group group : groups.getList()) {
			System.out.println(group.getGroupOid() + ": " + group.getNumber());
		}
		query = new ScheduleQuery(false, 444);
		try {
			ListAnswer<Day> days = pwner.getSchedule(query);
			for (Day day : days) {
				//System.out.println(day.getDate().toString());
				for (Subject subj : day.getSubjects()) {
					System.out.println(subj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
