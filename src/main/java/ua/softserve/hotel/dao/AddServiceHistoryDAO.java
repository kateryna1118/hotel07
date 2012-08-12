package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.AddServiceHistory;

/**
 *
 * @author Kateryna
 */
@Repository("AddServiceHistoryDAO")
public class AddServiceHistoryDAO implements IAddServiceHistoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addAddServiceHistory(AddServiceHistory addServiceHistory) {
        return (Long) sessionFactory.getCurrentSession().save(addServiceHistory);
    }

    @Override
    public void updateAddServiceHistory(AddServiceHistory addServiceHistory) {
        sessionFactory.getCurrentSession().update(addServiceHistory);
    }

    @Override
    public void removeAddServiceHistory(Long id) {
        AddServiceHistory toDelete = (AddServiceHistory) sessionFactory.getCurrentSession().
                get(AddServiceHistory.class, id);
        if (toDelete != null) {
            sessionFactory.getCurrentSession().delete(toDelete);
        }
    }

    @Override
    public AddServiceHistory getAddServiceHistory(Long id) {
        AddServiceHistory toReturn = (AddServiceHistory) sessionFactory.getCurrentSession().
                get(AddServiceHistory.class, id);
        return toReturn;
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<AddServiceHistory> getAllAddServiceHistories() {
//        List<AddServiceHistory> addServiceHistorys = sessionFactory.getCurrentSession().
//                createQuery("from AddServiceHistory").list();
//        return addServiceHistory;
   // }
 @SuppressWarnings("unchecked")
    @Override
    public List<AddServiceHistory> getAllAddServiceHistories() {
        List<AddServiceHistory> addServiceHistories = sessionFactory.getCurrentSession().
                createQuery("from AddServiceHistory").list();
        return addServiceHistories;
    }
//    @Override
//    public List<AddServiceHistory> getAllAddServiceHistories() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
}
