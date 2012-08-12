package ua.softserve.hotel.web;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.softserve.hotel.domain.*;
import ua.softserve.hotel.service.*;

/**
 *
 * @author Kateryna
 */
@Controller
@RequestMapping("/servisadd")
public class AddServisHistoryController {

     @Autowired
    private IAddServiceHistoryService iAddServiceHistoryService;
    @Autowired
    private IOrderService iorderService;
    @Autowired
    private IRoleService iroleService;
    @Autowired
    private IUserService iuserService;
    @Autowired
    private IAddServiseService iAddServiseService;

    @RequestMapping(value = "add_Service", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("addServiceHistory") AddServiceHistory addServiceHistory, BindingResult result, ModelMap model, HttpSession session) {

        //addService
        long addServiceId = addServiceHistory.getAddService().getId();
        AddService newAddService = iAddServiseService.getAddService(addServiceId);
        addServiceHistory.setAddService(newAddService);

        //hotelOrder
        long orderId = addServiceHistory.getOrder().getId();
        HotelOrder newHotelOrder = iorderService.getOrder(orderId);
        addServiceHistory.setOrder(newHotelOrder);

        //user
        long userId = addServiceHistory.getUser().getId();
        User newUser = iuserService.getUser(userId);
        addServiceHistory.setUser(newUser);

        session.setAttribute("addServiceHistoryId", iAddServiceHistoryService.addAddServiceHistory(addServiceHistory));
        //iAddServiceHistoryService.addAddServiceHistory(addServiceHistory); //hotelOrder.setUser(iUserService.getUserByUserName(session.getAttribute("userName").toString()));

        return "redirect:/servisadd";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllAddServiceHistories(Map<String, Object> map, HttpSession session) {

        AddServiceHistory addServiceHistory = new AddServiceHistory();

        map.put("addServiceHistory", addServiceHistory);
        map.put("getAllAddServiceHistories", iAddServiceHistoryService.getAllAddServiceHistories());
        map.put("serviceList", iAddServiseService.getAllAddServices());
        map.put("orderList", iorderService.getAllOrders());
        map.put("userList", iuserService.getAllUsers());
//        map.put("getRoleListFSH", iroleService.getRolesForAddServiseHistory());
//        map.put("usersListFSH", iuserService.getAllUsersFSH());

        try {
            map.put("getAddServiceHistoryId", session.getAttribute("addServiceHistoryId"));
        } catch (Exception e) {
        }

        return "servisadd";
    }
    //setters & getters=================================================

    public IAddServiceHistoryService getiAddServiceHistoryService() {
        return iAddServiceHistoryService;
    }

    public void setiAddServiceHistoryService(IAddServiceHistoryService iAddServiceHistoryService) {
        this.iAddServiceHistoryService = iAddServiceHistoryService;
    }
    
    public IOrderService getIorderService() {
        return iorderService;
    }

    public void setIorderService(IOrderService iorderService) {
        this.iorderService = iorderService;
    }
    
    public IUserService getIuserService() {
        return iuserService;
    }

    public void setIuserService(IUserService iuserService) {
        this.iuserService = iuserService;
    }

    public IAddServiseService getiAddServiseService() {
        return iAddServiseService;
    }

    public void setiAddServiseService(IAddServiseService iAddServiseService) {
        this.iAddServiseService = iAddServiseService;
    }

    public IRoleService getIroleService() {
        return iroleService;
    }
    
    public void setIroleService(IRoleService iroleService) {
        this.iroleService = iroleService;
    }
}