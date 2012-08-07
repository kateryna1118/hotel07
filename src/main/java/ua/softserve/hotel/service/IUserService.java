/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.softserve.hotel.service;

import java.util.List;
import ua.softserve.hotel.domain.User;

/**
 *
 * @author Kateryna
 */
public interface IUserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(Long id);

    public User getUser(Long id);

    public User getUserByUserName(String userName);

    public List<User> getAllUsers();

    public String getUserNameFromSecurity();
}
