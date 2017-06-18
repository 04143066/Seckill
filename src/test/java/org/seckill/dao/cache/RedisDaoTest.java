package java.org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xx on 2017/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    @Test
    public void testGetSeckill() throws Exception {

    }

    @Test
    public void testPutSeckill() throws Exception {
        
    }
}
