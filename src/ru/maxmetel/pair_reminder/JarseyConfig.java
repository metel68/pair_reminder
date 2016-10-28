package ru.maxmetel.pair_reminder;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by akoval on 15.07.2015.
 */
public class JarseyConfig extends ResourceConfig {
	public JarseyConfig() {
		packages("ru.maxmetel.pair_reminder.rest.resources", "ru.maxmetel.pair_reminder.rest.exceptions", "ru.maxmetel.pair_reminder.rest.filters");
		// register(CORSFilter.class);
	}
}
