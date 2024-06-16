package org.ztw.charades.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.UserExistsEx;
import org.ztw.charades.Exceptions.UserNotFoundEx;

import java.util.Collection;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User addUser(User user) throws UserExistsEx {
        Long _id = user.getId();
        if (userRepo.findById(_id).isPresent()) {
            throw new UserExistsEx(_id);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return userRepo.findById(_id).orElseThrow(
                () -> new UserNotFoundEx(_id)
        );
    }

    @Override
    public Collection<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Long id) throws UserNotFoundEx {
        return userRepo.findById(id).orElseThrow(
                () -> new UserNotFoundEx(id)
        );
    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) throws UserNotFoundEx {
        User old_user = userRepo.findById(id).orElseThrow(
                () -> new UserNotFoundEx(id)
        );
        old_user.setLogin(user.getLogin());
        old_user.setPassword(passwordEncoder.encode(user.getPassword()));
        old_user.setUsername(user.getUsername());
        userRepo.save(old_user);
        return old_user;
    }

    @Override
    @Transactional
    public Boolean deleteUser(Long id) throws UserNotFoundEx {
        if (userRepo.findById(id).isEmpty()) {
            throw new UserNotFoundEx(id);
        }
        userRepo.deleteById(id);
        return userRepo.findById(id).isEmpty();
    }
}
