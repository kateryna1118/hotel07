package ua.softserve.hotel.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.IUserService;

@Controller
@Path("/api")
public class Rest {
	
	@Autowired
    private IUserService iuserService;
	
	@GET
	@Produces("text/plain")
	public Response getTextMessage() {
		String result = "\n\nUSERS:";
		for(User p : iuserService.getAllUsers()) {
			result += "\n'" + p.toString() + "'";
		}
		
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Produces("application/json")
	public Response getJsonMessage() {
		String result = "{\n\nUSERS:";
		for(User p : iuserService.getAllUsers()) {
			result += "\n'" + p.toString() + "'";
		}
		result += "}";
		
		return Response.status(200).entity(result).build();
	}
}
