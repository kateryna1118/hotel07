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
import ua.softserve.hotel.domain.HotelOrder;
import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.IOrderService;
import ua.softserve.hotel.service.IUserService;


/**
 *
 * @author User
 */
@Controller
@RequestMapping("/allorders")


public class AllOrderController {
    
   
   @Autowired
    private IOrderService IOrderService;

    public IOrderService getIOrderService() {
        return IOrderService;
    }

    public void setIOrderService(IOrderService IOrderService) {
        this.IOrderService = IOrderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllOrders(Map<String, Object> map) {
        map.put("orders", new HotelOrder());
        map.put("getAllOrders", IOrderService.getAllOrders());

        return "allorders";
    }


 

    
        
        

}
