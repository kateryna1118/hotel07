package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.AddServiceDAO;
import ua.softserve.hotel.domain.AddService;

/**
 *
 * @author Kateryna
 */
@Service
@Transactional(readOnly = true)
public class AddServiceService implements IAddServiseService {

    @Autowired
    private AddServiceDAO addServiceDAO;

    @Transactional
    @Override
    public void addAddService(AddService addService) {
        addServiceDAO.addAddService(addService);
    }

    @Transactional
    @Override
    public void updateAddService(AddService AddService) {
        addServiceDAO.updateAddService(AddService);
    }

    @Transactional
    @Override
    public void removeAddService(Long id) {
        addServiceDAO.removeAddService(id);
    }

    @Transactional
    @Override
    public AddService getAddService(Long id) {
        return addServiceDAO.getAddService(id);
    }

    @Transactional
    @Override
    public List<AddService> getAllAddServices() {
        return addServiceDAO.getAllAddServices();
    }
}
