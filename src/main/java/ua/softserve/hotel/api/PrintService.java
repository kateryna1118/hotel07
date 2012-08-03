package ua.softserve.hotel.api;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
 
@Path("/api/api")
public class PrintService {
 
	CustomerBo customerBo;
 
	@GET
	@Path("/api/print")
	public Response printMessage(@Context ServletContext servletContext) {
 
		//get Spring application context
		ApplicationContext ctx = 
                     WebApplicationContextUtils.getWebApplicationContext(servletContext);
		customerBo= ctx.getBean("customerBo",CustomerBo.class);
 
		String result = customerBo.getMsg();
 
		return Response.status(200).entity(result).build();
 
	}
 
}
