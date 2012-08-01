
package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.AddService;

/**
 *
 * @author Kateryna
 */
public interface IAddServiseService {

    public void addAddService(AddService addService);

    public void updateAddService(AddService AddService);

    public void removeAddService(Long id);

    public AddService getAddService(Long id);

    public List<AddService> getAllAddServices();

}
