/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.AddServiceHistoryDAO;
import ua.softserve.hotel.domain.AddServiceHistory;

/**
 *
 * @author admin
 */
@Service
@Transactional(readOnly = true)
public class AddServiceHistoryService implements IAddServiceHistoryService {

    @Autowired
    private AddServiceHistoryDAO addServiceHistoryDAO;

    @Transactional
    public void addAddServiceHistory(AddServiceHistory addServiceHistory) {
        addServiceHistory.setDatePrice(addServiceHistory.getAddService().getPrice());
        addServiceHistoryDAO.addAddServiceHistory(addServiceHistory);
    }

    @Transactional
    public void updateAddServiceHistory(AddServiceHistory addServiceHistory) {
        addServiceHistoryDAO.updateAddServiceHistory(addServiceHistory);
    }

    @Transactional
    public void removeAddServiceHistory(Long id) {
        addServiceHistoryDAO.removeAddServiceHistory(id);
    }

    @Transactional
    public AddServiceHistory getAddServiceHistory(Long id) {
        return addServiceHistoryDAO.getAddServiceHistory(id);
    }

    @Transactional
    public List<AddServiceHistory> getAllAddServiceHistories() {
        return addServiceHistoryDAO.getAllAddServiceHistories();
    }
}
