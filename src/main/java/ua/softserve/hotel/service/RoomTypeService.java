package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.IRoomTypeDAO;
import ua.softserve.hotel.domain.RoomType;

/**
 *
 * @author Kateryna
 */
@Service
@Transactional(readOnly = true)
public class RoomTypeService implements IRoomTypeService{

    @Autowired
    private IRoomTypeDAO iroomTypeDAO;

    public IRoomTypeDAO getIroomTypeDAO() {
        return iroomTypeDAO;
    }

    public void setIroomTypeDAO(IRoomTypeDAO iroomTypeDAO) {
        this.iroomTypeDAO = iroomTypeDAO;
    }

    public void addRoomType(RoomType roomType) {
        iroomTypeDAO.addRoomType(roomType);
    }

    public void updateRoomType(RoomType roomType) {
        iroomTypeDAO.updateRoomType(roomType);
    }

    public void removeRoomType(Long id) {
        iroomTypeDAO.removeRoomType(id);
    }

    public RoomType getRoomType(Long id) {
        return iroomTypeDAO.getRoomType(id);
    }

    public List<RoomType> getAllRoomTypes() {
        return iroomTypeDAO.getAllRoomTypes();
    }

    public List<String> getAllRoomTypesNames() {

        return iroomTypeDAO.getAllRoomTypesNames();
    }
}
