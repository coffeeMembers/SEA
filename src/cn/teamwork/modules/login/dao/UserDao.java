package cn.teamwork.modules.login.dao;

import cn.teamwork.modules.login.model.User;

import java.util.List;

public interface UserDao {

	public User findUserByName(String name);

    public void update(User user);

	public void save(User user);

    public void delete(Long userId);

    List<User> findAllUsers();

    public User findUserById(long userId);

}
