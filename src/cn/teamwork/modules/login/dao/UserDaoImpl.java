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
        return (User) entityManager.createQuery("select u from User u where u.name=:name")
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

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath*:cn/teamwork/configurations/springconfig-jpa.xml"});
        UserDao userDao = context.getBean("userDao", UserDao.class);

//        User user = userDao.findUserByName("weihong.yin1");
//        user.setName("test");
//        userDao.update(user);
//        System.out.println(user);

        User newUser = new User("37502", "1234567890", "shaowei.hu");
        userDao.save(newUser);
    }
}
