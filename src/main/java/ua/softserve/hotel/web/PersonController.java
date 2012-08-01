package ua.softserve.hotel.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.softserve.hotel.domain.Person;
import ua.softserve.hotel.service.IPersonService;


/**
 *
 * @author Kateryna
 */
@Controller
public class PersonController {

    @Autowired
    private IPersonService ipersonService;

//    @RequestMapping("/")
//    public String home() {
//        return "redirect:/index";
//    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person,
            BindingResult result) {

        ipersonService.addPerson(person);

        return "redirect:/person";
    }

      @RequestMapping(value = "/person/update")
    public String updatePerson(@ModelAttribute("person") Person person,
            BindingResult result) {

        ipersonService.updatePerson(person);

        return "redirect:/";
    }

    @RequestMapping("/person/delete/{personId}")
    public String removePerson(@PathVariable("personId") Integer personId) {

        ipersonService.removePerson(personId);

        return "redirect:/";
    }

     @RequestMapping("/person/get/{personId}")
    public String getPerson(@PathVariable("personId") Integer personId) {

        ipersonService.getPerson(personId);

        return "redirect:/";
    }

        @RequestMapping("/person")
    public String getAllPersons(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("getAllPersons", ipersonService.getAllPersons());

        return "person";
    }
}
