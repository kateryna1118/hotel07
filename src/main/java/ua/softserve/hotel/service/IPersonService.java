package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.Person;

/**
 *
 * @author Kateryna
 */
public interface IPersonService {

    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void removePerson(Integer id);

    public Person getPerson(Integer id);

    public List<Person> getAllPersons();
}
