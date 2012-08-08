package ua.softserve.hotel.api;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

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
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(AddServiceHistory.class, new AddServiceHistoryAdapter()).create();
	    String result = gson.toJson(iAddServiceHistoryService.getAllAddServiceHistories());
	    return Response.status(200).entity(result).build();

		
//		String result = new Gson().toJson(iAddServiceHistoryService.getAllAddServiceHistories().get(0));
//		return Response.status(200).entity(result).build();
	}
	
	class AddServiceHistoryAdapter implements JsonSerializer<AddServiceHistory> {
	    @Override
	    public JsonElement serialize(AddServiceHistory service, Type type, JsonSerializationContext jsc) {	    	
	        JsonObject jsonObject = new JsonObject();
	        jsonObject.addProperty("message_id", service.getAmount());
	        jsonObject.addProperty("message", service.getDatePrice());
	        jsonObject.addProperty("id", service.getId());
	        jsonObject.add("addService", new Gson().toJsonTree(service.getAddService()));
//	        jsonObject.addProperty("message_id", service.getOpperationDate());
//	        jsonObject.addProperty("order", String.valueOf(null));
//	        jsonObject.addProperty("user", service.getUser());
	        return jsonObject;      
	    }
	}
	
	@GET
	@Produces("application/json")
	@Path("service/history/{role}")
	public Response getServiceHistory(@PathParam("role") String role) {
		String result;
		List<AddServiceHistory> services = new ArrayList<AddServiceHistory>();
		
		for(AddServiceHistory service :
			iAddServiceHistoryService.getAllAddServiceHistories()) {
			
			if(service.getUser().getRole().getName().equals(role) &&
					service.isClientPaid() == null) {
				services.add(service);
			}
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(AddServiceHistory.class, new AddServiceHistoryAdapter()).create();
	    result = gson.toJson(services);
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Produces("application/json")
	@Path("service/add")
	public Response addServiceHistory(String jsonString) {
		AddServiceHistory newAddService = new Gson().fromJson(jsonString, AddServiceHistory.class);
		
		System.err.println("!!!!!!!!!!!!!! newAddService:" + new Gson().toJson(newAddService));
		
		iAddServiceHistoryService.addAddServiceHistory(newAddService);
		// TODO save to DB
		return Response.status(200).build();
	}
}
