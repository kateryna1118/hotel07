package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.RoomDAO;
import ua.softserve.hotel.domain.Room;

/**
 *
 * @author Kateryna
 */
@Service
@Transactional(readOnly = true)
public class RoomService implements IRoomService {

    @Autowired
    private RoomDAO roomDAO;

    @Transactional
    public void addRoom(Room room) {
        roomDAO.addRoom(room);
    }

    @Transactional
    public void updateRoom(Room room) {
        roomDAO.updateRoom(room);
    }

    @Transactional
    public void removeRoom(Long id) {
        roomDAO.removeRoom(id);
    }

    @Transactional
    public Room getRoom(Long id) {
        return roomDAO.getRoom(id);
    }

    @Transactional
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }
}
