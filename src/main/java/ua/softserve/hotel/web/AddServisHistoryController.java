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
//@SessionAttributes("hotelOrder")
public class AddServisHistoryController {

     @Autowired
    private IAddServiceHistoryService iAddServiceHistoryService;

    public IAddServiceHistoryService getiAddServiceHistoryService() {
        return iAddServiceHistoryService;
    }

    public void setiAddServiceHistoryService(IAddServiceHistoryService iAddServiceHistoryService) {
        this.iAddServiceHistoryService = iAddServiceHistoryService;
    }
    
    @Autowired
    private IOrderService iorderService;

    public IOrderService getIorderService() {
        return iorderService;
    }

    public void setIorderService(IOrderService iorderService) {
        this.iorderService = iorderService;
    }
    
    @Autowired
    private IAddServiseService iAddServiseService;

    public IAddServiseService getiAddServiseService() {
        return iAddServiseService;
    }

    public void setiAddServiseService(IAddServiseService iAddServiseService) {
        this.iAddServiseService = iAddServiseService;
    }

    @RequestMapping(value = "showHistoryForm",method = RequestMethod.GET)
    public String showHistoryForm(ModelMap model) {

        HotelOrder hotelOrder = new HotelOrder();
        model.addAttribute(hotelOrder);
        
        AddServiceHistory addServiceHistory = new AddServiceHistory();
        model.addAttribute(addServiceHistory);
        
        
        AddService addService = new AddService();
        model.addAttribute(addService);
        model.addAttribute("addService", iAddServiseService.getAddService(addService.getId()));
        return "servisadd";
    }
    
        @RequestMapping(value = "add_Service", method = RequestMethod.POST)
        public String onSubmit(@ModelAttribute("addServiceHistory") AddServiceHistory addServiceHistory, BindingResult result, ModelMap model, HttpSession session) {
        long serviceTypeId = addServiceHistory.getAddService().getId();

        return "redirect:/servisadd";
    }
    
}