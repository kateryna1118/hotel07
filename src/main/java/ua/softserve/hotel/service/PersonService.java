package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.IPersonDAO;
import ua.softserve.hotel.domain.Person;

/**
 *
 * @author Kateryna
 */
@Service

public class PersonService implements IPersonService {

    @Autowired
    private IPersonDAO ipersonDAO;

    @Transactional
    public void addPerson(Person person) {

        ipersonDAO.addPerson(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        ipersonDAO.updatePerson(person);
    }

    @Transactional
    public void removePerson(Integer id) {
        ipersonDAO.removePerson(id);
    }

    @Transactional
    public Person getPerson(Integer id) {
        return ipersonDAO.getPerson(id);
    }

    @Transactional
    public List<Person> getAllPersons() {
        return ipersonDAO.getAllPersons();
    }
}
