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

    @Override
    public void addAddService(AddService addService) {
        		sessionFactory.getCurrentSession().save(addService);

    }

    @Override
    public void updateAddService(AddService addService) {
       sessionFactory.getCurrentSession().update(addService);
    }

    @Override
    public void removeAddService(Long id) {
       AddService toDelete = (AddService) sessionFactory.getCurrentSession().
				get(AddService.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
    }

    @Override
    public AddService getAddService(Long id) {
       AddService toReturn = (AddService) sessionFactory.getCurrentSession().
				get(AddService.class, id);
		return toReturn;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AddService> getAllAddServices() {
       List<AddService> addServices = sessionFactory.getCurrentSession().
				createQuery("from AddService").list();
		return addServices;
	}
}
