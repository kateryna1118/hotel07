package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.PersonDAO;
import ua.softserve.hotel.domain.Person;

/**
 *
 * @author Kateryna
 */
@Service

public class PersonService implements IPersonService {

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public void addPerson(Person person) {
        
        personDAO.addPerson(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    @Transactional
    public void removePerson(Integer id) {
        personDAO.removePerson(id);
    }

    @Transactional
    public Person getPerson(Integer id) {
        return personDAO.getPerson(id);
    }

    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }
}
