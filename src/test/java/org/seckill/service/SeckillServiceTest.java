package java.org.seckill.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xx on 16/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})

public class SeckillServiceTest {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills=seckillService.getSeckillList();
        System.out.println(seckills);
        //logger.info("seckill={}",seckill);
    }

    @Test
    public void getById() throws Exception {

        long seckillId=1000;
        Seckill seckill=seckillService.getById(seckillId);
        System.out.println(seckill);
        //logger.info("exposer={}",exposer);
    }

    @Test//完整逻辑代码测试，注意可重复执行
    public void testSeckillLogic() throws Exception {
        long seckillId=1000;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed())
        {

            System.out.println(exposer);
            //logger.info("exposer={}",exposer);

            long userPhone=13476191876L;
            String md5=exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                System.out.println(seckillExecution);
                //logger.info("result={}",execution);
            }catch (RepeatKillException e)
            {
                e.printStackTrace();
                //logger.info(e.getMessage());
            }catch (SeckillCloseException e1)
            {
                e1.printStackTrace();
                //logger.info(e.getMessage());
            }
        }else {
            //秒杀未开启
            System.out.println(exposer);
            //logger.info("exposer={}",exposer);
        }
    }

    @Test
    public void executeSeckill() throws Exception {

        long seckillId=1000;
        String md5="bf204e2683e7452aa7db1a50b5713bae";
    }

    @Test
    public void executeSeckillProdure(){
        long seckillId = 1001;
        long phone = 1368191110;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()){
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId,phone,md5);
            logger.info(execution.getStateInfo());
        }
        String md5 = null;
    }
}

