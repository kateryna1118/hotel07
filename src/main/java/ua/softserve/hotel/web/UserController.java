package ua.softserve.hotel.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
public class UserController {

    @Autowired
    private IUserService iuserService;

    public IUserService getIuserService() {
        return iuserService;
    }

    public void setIuserService(IUserService iuserService) {
        this.iuserService = iuserService;
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String createRegisterForm(Map<String, Object> model, HttpSession session) {
        session.setAttribute("userName", iuserService.getUserNameFromSecurity());
        model.put("user", new User());
        return "/user";
    }

    @RequestMapping(value = "/user_add")
    public String addUser(@ModelAttribute("user") User user,
            BindingResult result) {

        iuserService.addUser(user);

        return "redirect:/user";
    }

    @RequestMapping(value = "/user_update")
    public String updateUser(@ModelAttribute("user") User user,
            BindingResult result) {

        iuserService.updateUser(user);

        return "redirect:/user";
    }

    @RequestMapping("/delete_user/{userId}")
    public String removeUser(@PathVariable("userId") Long userId) {

        iuserService.removeUser(userId);

        return "redirect:/user";
    }

    @RequestMapping("/user_get")
    public User getUser( Long userId) {
        List<User> users = (List<User>) iuserService.getAllUsers();
        for (User User : users) {
            if (User.getId() == userId) {
                return User;
            }
        }
        return null;
    }

    @RequestMapping("/user")
    public String getAllUsers(Map<String, Object> map) {

        map.put("user", new User());
        map.put("getAllUsers", iuserService.getAllUsers());

        return "user";
    }
}
