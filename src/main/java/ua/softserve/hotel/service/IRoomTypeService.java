package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.RoomType;

/**
 *
 * @author Kateryna
 */
public interface IRoomTypeService {

    public void addRoomType(RoomType roomType);

    public void updateRoomType(RoomType roomType);

    public void removeRoomType(Long id);

    public RoomType getRoomType(Long id);

    public List<RoomType> getAllRoomTypes();

    public Object getAllRoomTypesNames();

}
