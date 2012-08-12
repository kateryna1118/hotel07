package ua.softserve.hotel.web;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.softserve.hotel.domain.HotelOrder;
import ua.softserve.hotel.domain.Person;
import ua.softserve.hotel.domain.RoomType;
import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.IOrderService;
import ua.softserve.hotel.service.IRoomTypeService;
import ua.softserve.hotel.service.IUserService;

/**
 *
 * @author Kateryna
 */
@Controller
@RequestMapping("/booking")
//@SessionAttributes("hotelOrder")
public class BookingController {

    @Autowired
    private IOrderService iorderService;

    public IOrderService getIorderService() {
        return iorderService;
    }

    public void setIorderService(IOrderService iorderService) {
        this.iorderService = iorderService;
    }

     @Autowired
    private IRoomTypeService iRoomTypeService;

    public IRoomTypeService getIRoomTypeService() {
        return iRoomTypeService;
    }

    public void setIRoomTypeService(IRoomTypeService IRoomTypeService) {
        this.iRoomTypeService = IRoomTypeService;
    }

    @Autowired
    private IUserService iUserService;

    public IRoomTypeService getiRoomTypeService() {
        return iRoomTypeService;
    }

    public void setiRoomTypeService(IRoomTypeService iRoomTypeService) {
        this.iRoomTypeService = iRoomTypeService;
    }

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @RequestMapping(value = "showBookingForm",method = RequestMethod.GET)
	public String showBookingForm(ModelMap model) {

		HotelOrder hotelOrder = new HotelOrder();
		model.addAttribute(hotelOrder);

         model.addAttribute("roomTypes", iRoomTypeService.getAllRoomTypes());


        RoomType roomType = new RoomType();
        model.addAttribute(roomType);

		return "booking";
	}

    @RequestMapping(value = "add_Order", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("hotelOrder") HotelOrder hotelOrder, BindingResult result, ModelMap model, HttpSession session) {
        long roomTypeId = hotelOrder.getRoomType().getId();
        RoomType newRoomType = iRoomTypeService.getRoomType(roomTypeId);

        hotelOrder.setRoomType(newRoomType);
        hotelOrder.setUser(iUserService.getUserByUserName(session.getAttribute("userName").toString()));

        //iorderService.addOrder(hotelOrder);
        session.setAttribute("orderId", iorderService.addOrder(hotelOrder));
		return "redirect:/booking";
	}

    @RequestMapping(method = RequestMethod.GET)
    public String getAllOrders(Map<String, Object> map, HttpSession session) {

        HotelOrder hotelOrder = new HotelOrder();

        map.put("hotelOrder", hotelOrder);
        map.put("getAllOrders", iorderService.getAllOrders());


        try {
            map.put("getOrder", iorderService.getOrder((Long) session.getAttribute("orderId")));
        } catch (Exception e) {
        }

        try {
            map.put("getOrderId", session.getAttribute("orderId"));
        } catch (Exception e) {
        }

        map.put("getAllRoomTypes", iRoomTypeService.getAllRoomTypes());
//        try {
//            map.put("deleteOrder", iorderService.removeOrder((Long) session.getAttribute("orderId")));
//        } catch (Exception e) {
//        }
        session.setAttribute("userName", iUserService.getUserNameFromSecurity());

        return "booking";
    }

//    @RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.GET)
//    public String getUser(@PathVariable("orderId") Long orderId) {
//
//        iorderService.removeOrder(orderId);
//
//        return "redirect:/booking";
//    }
}
