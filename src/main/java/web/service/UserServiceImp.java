package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.User;
import web.dao.UserDao;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDaoImp;

    @Autowired
    public void setUserDAO(UserDao userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDaoImp.saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDaoImp.deleteUser(user);
    }

    @Override
    public User getByIdUser(Long id) {
        return userDaoImp.getByIdUser(id);
    }

    @Override
    public void addUser(User user) {
        userDaoImp.saveUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDaoImp.getUser(id);
    }

    @Override
    public void updateUser(long id, User user) {
        User existingUser = userDaoImp.getUser(id);
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        userDaoImp.saveUser(existingUser);
    }
}
