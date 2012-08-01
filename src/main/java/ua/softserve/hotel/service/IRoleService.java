package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.Role;

/**
 *
 * @author Kateryna
 */
public interface IRoleService {

    public void addRole(Role role);

    public void updateRole(Role role);

    public void removeRole(Long id);

    public Role getRole(Long id);

    public List<Role> getAllRoles();

//    public Role getRole(int i);
}
