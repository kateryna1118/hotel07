package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.Room;

/**
 *
 * @author Kateryna
 */
public interface IRoomService {

    public void addRoom(Room room);

    public void updateRoom(Room room);

    public void removeRoom(Long id);

    public Room getRoom(Long id);

    public List<Room> getAllRooms();
}
