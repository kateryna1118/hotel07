
package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.HotelOrder;

/**
 *
 * @author Kateryna
 */
public interface IOrderService {

    public void addOrder(HotelOrder order);

    public void updateOrder(HotelOrder order);

    public void removeOrder(Long id);

    public HotelOrder getOrder(Long id);

    public List<HotelOrder> getAllOrders();

}

