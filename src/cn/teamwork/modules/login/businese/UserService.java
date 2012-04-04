package cn.teamwork.modules.login.businese;

import cn.teamwork.modules.login.dao.UserDao;
import cn.teamwork.modules.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findUser(String name){
        return userDao.findUserByName(name);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public List<User> findAll() {
        return  userDao.findAll();

    }
}
