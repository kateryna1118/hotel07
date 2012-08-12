/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.softserve.hotel.web;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.softserve.hotel.domain.AddServiceHistory;
import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.*;


/**
 *
 * @author User
 */
@Controller
@RequestMapping("/allservice")


public class AllServiceController {
    
   
    @Autowired
    private IAddServiceHistoryService iAddServiceHistoryService;

    public IAddServiceHistoryService getiAddServiceHistoryService() {
        return iAddServiceHistoryService;
    }

    public void setiAddServiceHistoryService(IAddServiceHistoryService iAddServiceHistoryService) {
        this.iAddServiceHistoryService = iAddServiceHistoryService;
    }

    public IAddServiseService getiAddServiseService() {
        return iAddServiseService;
    }

    public void setiAddServiseService(IAddServiseService iAddServiseService) {
        this.iAddServiseService = iAddServiseService;
    }

    public IOrderService getIorderService() {
        return iorderService;
    }

    public void setIorderService(IOrderService iorderService) {
        this.iorderService = iorderService;
    }

    public IRoleService getIroleService() {
        return iroleService;
    }

    public void setIroleService(IRoleService iroleService) {
        this.iroleService = iroleService;
    }

    public IUserService getIuserService() {
        return iuserService;
    }

    public void setIuserService(IUserService iuserService) {
        this.iuserService = iuserService;
    }
    @Autowired
    private IOrderService iorderService;
    @Autowired
    private IRoleService iroleService;
    @Autowired
    private IUserService iuserService;
    @Autowired
    private IAddServiseService iAddServiseService;

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

        return "allservice";
    }

}
