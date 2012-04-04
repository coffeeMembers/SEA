package cn.teamwork.modules.login.dao;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import cn.teamwork.modules.login.model.User;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:cn/teamwork/configurations/springconfig-jpa.xml")
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

	@Test
	public void testFindUserByName() {
		assertThat(userDao.findUserByName("test").getCode(), is("54030"));
	}

    @Test
    public void testUpdate() {
        User user = userDao.findUserByName("test");
        user.setCode("54030");
        userDao.update(user);

        assertThat(userDao.findUserByName("test").getCode(), is("54030"));
    }

    @Test
    public void testSave(){
        User user = new User("9527","1234567890","zhouxingxing");

        userDao.save(user);

        assertThat(userDao.findUserByName("zhouxingxing").getCode(),is("9527"));
    }

}
