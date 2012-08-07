/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.softserve.hotel.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.IUserService;


/**
 *
 * @author User
 */
@Controller
@RequestMapping("/hotelmanager")


public class ManagerController {
    
   
   @Autowired
    private IUserService iUserService;
   

    public IUserService getIuserService() {
        return iUserService;
    }

    public void setIuserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showBookingForm() {
		return "hotelmanager";
	}



 

    
        
        

}
