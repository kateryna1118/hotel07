package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.RoleDAO;
import ua.softserve.hotel.domain.Role;

/**
 *
 * @author Kateryna
 */
@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService {

    @Autowired
    private RoleDAO roleDAO;


    /*Перед исполнением метода помеченного @Transactional аннотацией начинается
    транзакция, после выполнения метода транзакция коммитится, при выбрасывании
    RuntimeException откатывается.
      */
    @Transactional
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Transactional
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Transactional
    public void removeRole(Long id) {
        roleDAO.removeRole(id);
    }

    @Transactional
    public Role getRole(Long id) {
        return roleDAO.getRole(id);
    }

    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
