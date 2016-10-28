package ru.maxmetel.pair_reminder.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ru.maxmetel.pair_reminder.model.Group;
import ru.maxmetel.pair_reminder.model.ListAnswer;
import ru.maxmetel.pair_reminder.network.OmstuPwner;
import ru.maxmetel.pair_reminder.network.ScheduleQuery;
import ru.maxmetel.pair_reminder.rest.exceptions.RestException;

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
