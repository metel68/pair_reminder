package ru.maxmetel.pair_reminder.rest.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ru.maxmetel.pair_reminder.model.Day;
import ru.maxmetel.pair_reminder.model.Group;
import ru.maxmetel.pair_reminder.model.ListAnswer;
import ru.maxmetel.pair_reminder.network.OmstuPwner;
import ru.maxmetel.pair_reminder.network.ScheduleQuery;
import ru.maxmetel.pair_reminder.rest.exceptions.RestException;

@Path("api/lessons")
public class ScheduleResource {
	@GET
	@Produces("application/json")
	public Response get(@QueryParam("group")Integer group, @QueryParam("lecturer")Integer lecturer)
	{
		try {
			OmstuPwner pwner = new OmstuPwner();
			ScheduleQuery query = new ScheduleQuery(group == null, group == null ? lecturer : group);
			ListAnswer<Day> schedule = pwner.getSchedule(query);
			return Response.ok(schedule).build();	
		} catch (RestException | IOException e) {
			e.printStackTrace();
			return Response.serverError().entity(new ListAnswer<Void>(e.getMessage())).build();
		}
	}
}
