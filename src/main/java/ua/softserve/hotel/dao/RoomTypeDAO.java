package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.RoomType;

/**
 *
 * @author Kateryna
 */
@Repository("RoomTypeDAO")
public class RoomTypeDAO implements IRoomTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addRoomType(RoomType roomType) {
       sessionFactory.getCurrentSession().save(roomType);
    }


    public void updateRoomType(RoomType roomType) {
        sessionFactory.getCurrentSession().update(roomType);
    }


    public void removeRoomType(Long id) {
        RoomType toDelete = (RoomType) sessionFactory.getCurrentSession().
				get(RoomType.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
    }


    public RoomType getRoomType(Long id) {
       RoomType toReturn = (RoomType) sessionFactory.getCurrentSession().
				get(RoomType.class, id);
		return toReturn;
    }


    public List<RoomType> getAllRoomTypes() {
       List<RoomType> roomTypes = sessionFactory.getCurrentSession().
				createQuery("from RoomType").list();
		return roomTypes;
	}

    public List<String> getAllRoomTypesNames() {
        List<String> roomTypesNames=(List<String>)sessionFactory.getCurrentSession().createSQLQuery("select NAME from ROOM_TYPE order by ROOM_TYPE_ID")
	.addScalar("name").setResultTransformer(Transformers.aliasToBean(RoomType.class)).list();

        return roomTypesNames;
	}


}
