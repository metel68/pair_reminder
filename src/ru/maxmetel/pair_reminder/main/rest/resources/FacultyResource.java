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

@Path("api/faculties")
public class FacultyResource {
	@GET
	@Produces("application/json")
	public Response get() {
		try {
			OmstuPwner pwner = new OmstuPwner();
			ListAnswer<String> groups = pwner.getFaculties();
			return Response.ok(groups).build();	
		} catch (RestException e) {
			e.printStackTrace();
			return Response.serverError().entity(new ListAnswer<Void>(e.getMessage())).build();
		}
	}

}
