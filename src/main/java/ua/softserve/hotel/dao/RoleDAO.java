package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.Role;

/**
 *
 * @author Kateryna
 */
@Repository("RoleDAO")
public class RoleDAO implements IRoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }


    public void updateRole(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }


    public void removeRole(Long id) {
        Role toDelete = (Role) sessionFactory.getCurrentSession().
                get(Role.class, id);
        if (toDelete != null) {
            sessionFactory.getCurrentSession().delete(toDelete);
        }
    }


    public Role getRole(Long id) {
        Role toReturn = (Role) sessionFactory.getCurrentSession().
                get(Role.class, id);
        return toReturn;
    }

    @SuppressWarnings("unchecked")

    public List<Role> getAllRoles() {
        List<Role> roles = sessionFactory.getCurrentSession().
                createQuery("from Roles").list();
        return roles;
    }
}
