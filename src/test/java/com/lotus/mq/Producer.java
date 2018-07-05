package com.lotus.mq;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;


@Service
public class Producer {
    @Resource
    private JmsTemplate jmsQueueTemplate;


    public void sendMessage(String destinationName,String message){
        System.out.println(">>>>>>>>>======发送queue消息："+message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsQueueTemplate.convertAndSend(destination,message);
    }

}
