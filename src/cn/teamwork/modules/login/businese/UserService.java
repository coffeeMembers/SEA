package cn.teamwork.modules.login.businese;

import cn.teamwork.modules.login.dao.UserDao;
import cn.teamwork.modules.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findUserByName(String name){
        return userDao.findUserByName(name);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public List<User> findAllUsers() {
        return  userDao.findAllUsers();

    }

    public void update(User user) {
        userDao.update(user);
    }

    public User findUserById(long userId) {
        return userDao.findUserById(userId);
    }

    public void delete(Long userId) {
        userDao.delete(userId);
    }
}
