package ua.softserve.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.softserve.hotel.domain.HotelOrder;
import ua.softserve.hotel.service.IOrderService;
import ua.softserve.hotel.service.IRoomTypeService;

/**
 *
 * @author Kateryna
 */
@Controller
@RequestMapping("/booking")
@SessionAttributes("hotelOrder")

public class BookingController {

    @Autowired
    private IOrderService iorderService;

     @Autowired
    private IRoomTypeService iRoomTypeService;

       @RequestMapping(method = RequestMethod.GET)
	public String showBookingForm(ModelMap model) {
		HotelOrder hotelOrder = new HotelOrder();
		model.addAttribute(hotelOrder);
		return "booking";
	}

       @RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("hotelOrder") HotelOrder hotelOrder) {
		iorderService.addOrder(hotelOrder);
		return "redirect:/booking";
	}
//    @RequestMapping(value = "/booking/add", method = RequestMethod.GET)
//    public String addHotelOrder(@ModelAttribute("HotelOrder") HotelOrder hotelOrder,
//            BindingResult result) {
//        iorderService.addOrder(hotelOrder);
//        return "redirect:/user";
//    }
//     @RequestMapping(value ="/booking/get_allRoomTypes",method = RequestMethod.POST)
//    public String getAllRoomeTypes(Map<String, Object> map) {
//
//        map.put("booking", new HotelOrder());
//        map.put("getAllRoomeTypes", iRoomTypeService.getAllRoomTypes());
//
//        return "booking";
//    }
//      @RequestMapping("/booking/get_allOrders")
//    public String getAllOrders(Map<String, Object> map) {
//
//        map.put("booking", new RoomType());
//        map.put("getAllOrders", iorderService.getAllOrders());
//
//        return "booking";
//    }
    public IRoomTypeService getiRoomTypeService() {
        return iRoomTypeService;
    }

    public void setiRoomTypeService(IRoomTypeService iRoomTypeService) {
        this.iRoomTypeService = iRoomTypeService;
    }

    public IOrderService getIorderService() {
        return iorderService;
    }

    public void setIorderService(IOrderService iorderService) {
        this.iorderService = iorderService;
    }




}
