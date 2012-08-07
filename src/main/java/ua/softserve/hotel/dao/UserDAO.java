/**
 *
 * @author Kateryna
 */
package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.User;

@Repository("UserDAO")
public class UserDAO implements IUserDAO {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Autowired
	private SessionFactory sessionFactory;


	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}


	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}


	public void removeUser(Long id) {
		User toDelete = (User) sessionFactory.getCurrentSession().
				get(User.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
	}


	public User getUser(Long id) {
		User toReturn = (User) sessionFactory.getCurrentSession().
				get(User.class, id);
		return toReturn;
	}

        public User getUserByUserName(String userName){
            User toReturn = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", userName)).uniqueResult();
		return toReturn;
        }

	@SuppressWarnings("unchecked")

	public List<User> getAllUsers() {
		List<User> users = sessionFactory.getCurrentSession().
				createQuery("from User").list();
		return users;
	}
}
