package ua.softserve.hotel.api;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Path("/api")
public class Rest {
	
	CustomerBo customerBo;
	
      @GET
      @Produces("application/json")
      public String getXMLMessage(@Context ServletContext servletContext) {
	    	//get Spring application context
	  		ApplicationContext ctx = 
	                       WebApplicationContextUtils.getWebApplicationContext(servletContext);
	  		customerBo = ctx.getBean("customerBo",CustomerBo.class);
	   
	  		String result = customerBo.getMsg();
	  		
//    	  return "{'message':'Hello world'}";
	  		return result.toString();
      }
}
