package ru.maxmetel.pair_reminder.main;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by akoval on 15.07.2015.
 */
public class JarseyConfig extends ResourceConfig {
	public JarseyConfig() {
		packages("ru.maxmetel.pair_reminder.main.rest.resources", "ru.maxmetel.pair_reminder.main.rest.exceptions", "ru.maxmetel.pair_reminder.main.rest.filters");
		// register(CORSFilter.class);
	}
}
