package com.lotus.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 生产者/消费者模式 [点对点]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQQueueTest {

    @Resource
    private Producer producer;

    @Test
    public void contextLoads(){
        for (int i = 0;i<10;i++){
            producer.sendMessage("test-queue-3","Queue Message:"+i);
        }
    }



}
