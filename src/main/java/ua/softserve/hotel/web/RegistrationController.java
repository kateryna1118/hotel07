package ua.softserve.hotel.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.softserve.hotel.domain.User;
import ua.softserve.hotel.service.IUserService;


/**
 *
 * @author Kateryna
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private IUserService iUserService;

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

//    @RequestMapping("/")
//    public String home() {
//        return "redirect:/index";
//    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user,
            BindingResult result) {

        iUserService.addUser(user);

        return "redirect:/user";
    }

      @RequestMapping(value = "update")
    public String updateUser(@ModelAttribute("user") User user,
            BindingResult result) {

        iUserService.updateUser(user);

        return "redirect:/";
    }

    @RequestMapping("delete/{userId}")
    public String removeUser(@PathVariable("userId") Long userId) {

        iUserService.removeUser(userId);

        return "redirect:/";
    }

     @RequestMapping("get/{userId}")
    public String getUser(@PathVariable("userId") Long userId) {

        iUserService.getUser(userId);

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Map<String, Object> map) {

        map.put("user", new User());
        map.put("getAllUsers", iUserService.getAllUsers());

        return "registration";
    }
}
