package org.ztw.charades.User;

import org.ztw.charades.Exceptions.UserExistsEx;
import org.ztw.charades.Exceptions.UserNotFoundEx;

import java.util.Collection;

public interface IUserService {
    abstract public User addUser(User user) throws UserExistsEx;
    abstract public Collection<User> getUsers();
    abstract public User getUser(Long id) throws UserNotFoundEx;
    abstract public User updateUser(Long id, User user) throws UserNotFoundEx;
    abstract public Boolean deleteUser(Long id) throws UserNotFoundEx;
}
