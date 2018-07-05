package com.lotus.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Subscriber {

    @JmsListener(destination = "test-topic-1",containerFactory = "jmsListenerContainerTopicFactory")
    public void subscribe(String text){
        System.out.println("<<<<<<<=====收到订阅topic消息"+text);
    }


    @JmsListener(destination = "test-topic-1",containerFactory = "jmsListenerContainerTopicFactory")
    public void subscribe1(String text){
        System.out.println("<<<<<<<=====1-收到订阅topic消息"+text);
    }



}
