package cn.teamwork.modules.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.teamwork.modules.login.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public User findUserByName(String name) {
        return entityManager.createQuery("select u from User u where u.name=:name", User.class)
                .setParameter("name", name).getSingleResult();
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void delete(Long userId) {
        User user = findUserById(userId);
        entityManager.remove(user);
    }

    public List<User> findAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User findUserById(long userId) {
        return entityManager.createQuery("select u from User u where u.id=:id", User.class)
                .setParameter("id", userId).getSingleResult();
    }

//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[]{"classpath*:cn/teamwork/configurations/springconfig-jpa.xml"});
//        UserDao userDao = context.getBean("userDao", UserDao.class);
//
//        User user = userDao.findUserByName("weihong.yin1");
//        user.setName("test");
//        userDao.update(user);
//        System.out.println(user);
//
//        User newUser = new User("37502", "1234567890", "shaowei.hu");
//        userDao.save(newUser);
//    }
}
