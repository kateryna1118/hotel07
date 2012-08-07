package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.OrderDAO;
import ua.softserve.hotel.domain.HotelOrder;

/**
 *
 * @author Kateryna
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    public void addOrder(HotelOrder order) {

        orderDAO.addOrder(order);
    }

    @Transactional
    public void updateOrder(HotelOrder order) {
        orderDAO.updateOrder(order);
    }

    @Transactional
    public void removeOrder(Long id) {
        orderDAO.removeOrder(id);
    }

    @Transactional
    public HotelOrder getOrder(Long id) {
        return orderDAO.getOrder(id);
    }

    @Transactional
    public List<HotelOrder> getAllOrders() {
        return orderDAO.getAllOrders();
    }

   
}
