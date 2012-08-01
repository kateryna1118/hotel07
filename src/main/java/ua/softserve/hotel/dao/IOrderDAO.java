package ua.softserve.hotel.dao;

import java.util.List;
import ua.softserve.hotel.domain.HotelOrder;

/**
 *
 * @author Kateryna
 */
public interface IOrderDAO {

    public void addOrder(HotelOrder order);

    public void updateOrder(HotelOrder order);

    public void removeOrder(Long id);

    public HotelOrder getOrder(Long id);

    public List<HotelOrder> getAllOrders();
}
