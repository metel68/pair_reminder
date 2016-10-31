package ru.maxmetel.pair_reminder.main.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ru.maxmetel.pair_reminder.main.model.Lecturer;
import ru.maxmetel.pair_reminder.main.model.ListAnswer;
import ru.maxmetel.pair_reminder.main.network.OmstuPwner;
import ru.maxmetel.pair_reminder.main.rest.exceptions.RestException;

@Path("api/lecturers")
public class LecturerResource {
	@GET
	@Produces("application/json")
	public Response get(@QueryParam("name")String name)
	{
		try {
			OmstuPwner pwner = new OmstuPwner();
			ListAnswer<Lecturer> lecturers;
			if (name.length() == 0) throw new RestException("No lecturer name!");
			if (name.length() == 1) {
				lecturers = pwner.getLecturers(name.charAt(0));
			} else {
				lecturers = pwner.getLecturers(name);
			}
			return Response.ok(lecturers).build();	
		} catch (RestException e) {
			e.printStackTrace();
			return Response.serverError().entity(new ListAnswer<Void>(e.getMessage())).build();
		}
	}
}
