package com.lotus.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 发布/订阅模式
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQTopicTest {

    @Resource
    private Publisher publisher;

    @Test
    public void contextLoads(){
        for (int i = 0;i<10;i++){
            publisher.publish("test-topic-1","Topic Message:"+i);
        }
    }


}
