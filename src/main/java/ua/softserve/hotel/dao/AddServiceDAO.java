package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.AddService;

/**
 *
 * @author Kateryna
 */
@Repository("AddServiceDAO")
public class AddServiceDAO implements IAddServiceDAO {

    @Autowired
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAddService(AddService addService) {
        		sessionFactory.getCurrentSession().save(addService);

    }

    public void updateAddService(AddService addService) {
       sessionFactory.getCurrentSession().update(addService);
    }

    public void removeAddService(Long id) {
       AddService toDelete = (AddService) sessionFactory.getCurrentSession().
				get(AddService.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
    }

    public AddService getAddService(Long id) {
       AddService toReturn = (AddService) sessionFactory.getCurrentSession().
				get(AddService.class, id);
		return toReturn;
    }

    @SuppressWarnings("unchecked")
    public List<AddService> getAllAddServices() {
       List<AddService> addServices = sessionFactory.getCurrentSession().
				createQuery("from AddService").list();
		return addServices;
	}
}
