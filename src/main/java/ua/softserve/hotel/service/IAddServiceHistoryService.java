package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.AddServiceHistory;

/**
 *
 * @author admin
 */
public interface IAddServiceHistoryService {

    public Long addAddServiceHistory(AddServiceHistory addServiceHistory);

    public void updateAddServiceHistory(AddServiceHistory addServiceHistory);

    public void removeAddServiceHistory(Long id);

    public AddServiceHistory getAddServiceHistory(Long id);

    public List<AddServiceHistory> getAllAddServiceHistories();
}
