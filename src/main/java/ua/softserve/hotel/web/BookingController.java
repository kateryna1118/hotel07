package ua.softserve.hotel.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.softserve.hotel.domain.HotelOrder;
import ua.softserve.hotel.domain.RoomType;
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

//        RoomType roomType=new RoomType();
//         model.addAttribute(roomType);
         model.addAttribute("roomTypes", iRoomTypeService.getAllRoomTypes());


        RoomType roomType = new RoomType();
        model.addAttribute(roomType);

		return "booking";
	}

//    @ModelAttribute("hotelOrder")
//    public HotelOrder newHotelOrder() {
//        return new HotelOrder();
//    }

//    @RequestMapping(value="/input",method = RequestMethod.GET)
//	public String input(Model model){
//       model.addAttribute("count", promosService.countPromos());
//       model.addAttribute("rentPromo", new RentPromo());
//       model.addAttribute("rentTypes", RentType.getRentTypes());
//	   return "input";
//	}

    @RequestMapping(value = "add_Order", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("hotelOrder") HotelOrder hotelOrder, BindingResult result, ModelMap model, HttpSession session) {
        long roomTypeId = hotelOrder.getRoomType().getId();
        RoomType newRoomType = iRoomTypeService.getRoomType(roomTypeId);

        hotelOrder.setRoomType(newRoomType);
        hotelOrder.setUser(iUserService.getUserByUserName(session.getAttribute("userName").toString()));

		iorderService.addOrder(hotelOrder);

		return "redirect:/booking";
	}

    @RequestMapping(method = RequestMethod.GET)
    public String getAllOrders(Map<String, Object> map, HttpSession session) {

        HotelOrder hotelOrder = new HotelOrder();

        map.put("hotelOrder", hotelOrder);
        map.put("getAllOrders", iorderService.getAllOrders());

        map.put("getOrder",iorderService.getOrder(hotelOrder.getId()));

        map.put("getAllRoomTypes", iRoomTypeService.getAllRoomTypes());

//        map.put("theName", iUserService.getUserNameFromSecurity());
        session.setAttribute("userName", iUserService.getUserNameFromSecurity());

        return "booking";
    }

// @RequestMapping(value = "getUserNameFromSecurity", method = RequestMethod.GET)
//    public String getUserNameFromSecurity() {
//           String userName=(iorderService.getUserNameFromSecurity());
//          // User user=iUserService.getUserByUserName(userName);
//        return userName;
//    }
//    @RequestMapping(value = "/booking/add", method = RequestMethod.GET)
//    public String addHotelOrder(@ModelAttribute("HotelOrder") HotelOrder hotelOrder,
//            BindingResult result) {
//        iorderService.addOrder(hotelOrder);
//        return "redirect:/user";
//    }
//

//     public IUserService getiUserService() {
//        return iUserService;
//    }
//
//    public void setiUserService(IUserService iUserService) {
//        this.iUserService = iUserService;
//    }
}
