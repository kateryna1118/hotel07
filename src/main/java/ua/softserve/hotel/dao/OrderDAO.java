package ua.softserve.hotel.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.HotelOrder;
import ua.softserve.hotel.domain.Room;

/**
 *
 * @author Kateryna
 */
@Repository("OrderDAO")
public class OrderDAO implements IOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long addOrder(HotelOrder order) {
        return (Long) sessionFactory.getCurrentSession().save(order);
    }

    public void updateOrder(HotelOrder order) {
        sessionFactory.getCurrentSession().update(order);
    }

    public void removeOrder(Long id) {
        HotelOrder toDelete = (HotelOrder) sessionFactory.getCurrentSession().
                get(HotelOrder.class, id);
        if (toDelete != null) {
            sessionFactory.getCurrentSession().delete(toDelete);
        }
    }

    public HotelOrder getOrder(Long id) {
        HotelOrder toReturn = (HotelOrder) sessionFactory.getCurrentSession().
                get(HotelOrder.class, id);
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    public List<HotelOrder> getAllOrders() {
        List<HotelOrder> orders = sessionFactory.getCurrentSession().
                createQuery("from HotelOrder").list();
        return orders;
    }
//    public List<HotelOrder> getOrdersById(HotelOrder order) {
//
//        List<HotelOrder> getOrdersById = new ArrayList<HotelOrder>();
//        Query q = sessionFactory.getCurrentSession().createQuery("from HotelOrder where ORDER_ID = :ORDER_ID");
//        q.setParameter("ORDER_ID", order.getId());
//        getOrdersById = q.list();
//
//        return getOrdersById;
//    }

//    public HotelOrder getLastOrder() {
//          LinkedList<HotelOrder> allOrders=(LinkedList<HotelOrder>) getAllOrders();
//        HotelOrder toReturn = allOrders.getLast();
//        return toReturn;
//    }

//    public List<HotelOrder> getOrdersById(Long id) {
//        List<HotelOrder> allOrders = getAllOrders();
//
//        List<HotelOrder> ordersById = new ArrayList<HotelOrder>();
//
//        for (HotelOrder order : allOrders) {
//            if (id == order.getId());
//            ordersById.add(order);
//
//        }
//        return ordersById;
//    }
}
