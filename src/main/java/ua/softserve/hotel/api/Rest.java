package ua.softserve.hotel.api;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.softserve.hotel.domain.AddServiceHistory;
import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.IAddServiceHistoryService;
import ua.softserve.hotel.service.IAddServiseService;
import ua.softserve.hotel.service.IRoomService;
import ua.softserve.hotel.service.IUserService;

import com.google.gson.Gson;

@Controller
@Path("api")
public class Rest {
	
	@Autowired private IUserService iUserService;
	@Autowired private IRoomService iRoomService;
	@Autowired private IAddServiseService iAddServiceService;
	@Autowired private IAddServiceHistoryService iAddServiceHistoryService;

	@GET
	@Produces("application/json")
	@Path("login")
	public Response checkLogin(@QueryParam("login") String login, @QueryParam("pass") String pass) {
		String result = "false";
		// Check passwd
		for(User usr : iUserService.getAllUsers()) {
			if(usr.getUsername().equals(login)) {
				if(usr.getPassword().equals(pass)) {
					result = new Gson().toJson(usr);
				}
				break;
			}
		}
		
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("room/list")
	public Response getRoomList() {
		String result = new Gson().toJson(iRoomService.getAllRooms());
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("service/list")
	public Response getServiceList() {
		String result = new Gson().toJson(iAddServiceService.getAllAddServices());
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("service/history")
	public Response getServiceHistory() {
		String result = new Gson().toJson(iAddServiceHistoryService.getAllAddServiceHistories());
		return Response.status(200).entity(result).build();
	}
	
	@PUT
	@Produces("application/json")
	@Path("service/add")
	public Response addServiceHistory() {
		AddServiceHistory newAddService = new Gson().fromJson("", AddServiceHistory.class);
		iAddServiceHistoryService.addAddServiceHistory(newAddService);
		return Response.status(200).build();
	}
}
