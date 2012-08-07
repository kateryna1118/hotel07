package ua.softserve.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.IUserDAO;
import ua.softserve.hotel.dao.RoleDAO;

import ua.softserve.hotel.dao.UserDAO;
import ua.softserve.hotel.domain.User;
/**
 *
 * @author Kateryna
 */
@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {

    @Autowired
    private IUserDAO iuserDAO;

    @Autowired
    private IRoleService IRoleService;

    public ua.softserve.hotel.service.IRoleService getIRoleService() {
        return IRoleService;
    }

    public void setIRoleService(ua.softserve.hotel.service.IRoleService IRoleService) {
        this.IRoleService = IRoleService;
    }

    public IUserDAO getIuserDAO() {
        return iuserDAO;
    }

    public void setIuserDAO(IUserDAO iuserDAO) {
        this.iuserDAO = iuserDAO;
    }

    /*Перед исполнением метода помеченного @Transactional аннотацией начинается
    транзакция, после выполнения метода транзакция коммитится, при выбрасывании
    RuntimeException откатывается.
      */
    @Transactional
    public void addUser(User user) {
       // user.setRole(user.getRole().);
        user.setRole(IRoleService.getRole(1L));
        user.setEnabled(Boolean.TRUE);
        iuserDAO.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        iuserDAO.updateUser(user);
    }

    @Transactional
    public void removeUser(Long id) {
        iuserDAO.removeUser(id);
    }

    @Transactional
    public User getUser(Long id) {
        return iuserDAO.getUser(id);
    }
   @Transactional
    public User getUserByUserName(String userName) {
        return iuserDAO.getUserByUserName(userName);
    }

    @Transactional
    public List<User> getAllUsers() {
        return iuserDAO.getAllUsers();
    }

    @Override
    public String getUserNameFromSecurity() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}