package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.RoomTypeDAO;
import ua.softserve.hotel.domain.RoomType;

/**
 *
 * @author Kateryna
 */
@Service
@Transactional(readOnly = true)
public class RoomTypeService implements IRoomTypeService{

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    public void addRoomType(RoomType roomType) {
        roomTypeDAO.addRoomType(roomType);
    }

    public void updateRoomType(RoomType roomType) {
        roomTypeDAO.updateRoomType(roomType);
    }

    public void removeRoomType(Long id) {
       roomTypeDAO.removeRoomType(id);
    }

    public RoomType getRoomType(Long id) {
        return roomTypeDAO.getRoomType(id);
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeDAO.getAllRoomTypes();
    }


}
