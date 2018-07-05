package com.lotus.mq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class Publisher {
    @Resource
    private JmsTemplate jmsTopicTemplate;

    public void publish(String destinationName,String message){
        System.out.println(">>>>>>>>>======发布topic消息："+message);
        Destination destination = new ActiveMQTopic(destinationName);
        jmsTopicTemplate.convertAndSend(destination,message);

    }


}
