import com.alibaba.fastjson.JSON;
import org.goiot.mapper.UserMapper;
import org.goiot.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chenxing on 2017/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-context-loader.xml")
public class DaoTest {
    @Autowired
    private UserMapper userDao;

    @Test
    public void testDao() {
        //UserEntity userEntity = userDao.selectByPrimaryKey(1L);
        List<UserEntity> userEntities = userDao.selectByPrimaryKeyBatch(new Long[]{1L});
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("goiot1");
//        userEntity.setRole(Role.Normal);
//        userEntity.setNickName("chenxing1");
//        userEntity.setPassword("tttt");
//        userEntity.setRememberMe(true);
//        userEntity.setDescription("test for common mapper");
//        userDao.insert(userEntity);
        System.out.println(JSON.toJSON(userEntities));
    }

}
