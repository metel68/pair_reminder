package ru.maxmetel.pair_reminder.main.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ru.maxmetel.pair_reminder.main.model.Group;
import ru.maxmetel.pair_reminder.main.model.ListAnswer;
import ru.maxmetel.pair_reminder.main.network.OmstuPwner;
import ru.maxmetel.pair_reminder.main.network.ScheduleQuery;
import ru.maxmetel.pair_reminder.main.rest.exceptions.RestException;

@Path("api/groups")
public class GroupResource {
	@GET
	@Produces("application/json")
	public Response get(@QueryParam("faculty")String faculty, @QueryParam("course")Integer course)
	{
		try {
			OmstuPwner pwner = new OmstuPwner();
			ScheduleQuery query = new ScheduleQuery(faculty, course != null ? course : 0);
			ListAnswer<Group> groups = pwner.getGroups(query);
			return Response.ok(groups).build();	
		} catch (RestException e) {
			e.printStackTrace();
			return Response.serverError().entity(new ListAnswer<Void>(e.getMessage())).build();
		}
	}
}
