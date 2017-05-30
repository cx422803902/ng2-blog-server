import com.alibaba.fastjson.JSON;
import org.goiot.dao.UserDao;
import org.goiot.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenxing on 2017/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-context-loader.xml")
public class DaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testDao() {
        UserEntity userEntity = userDao.selectById(1L);
        System.out.println(JSON.toJSON(userEntity));
    }

}
