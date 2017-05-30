import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSessionFactory;
import org.goiot.dao.TestDao;
import org.goiot.dao.TestEntity;
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
    private TestDao testDao;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testDao() {
        TestEntity entity = new TestEntity();
        entity.setName("hello, world");
        int result = testDao.insert(entity);
        System.out.println(result);
        System.out.println(JSON.toJSON(entity));
    }

}
