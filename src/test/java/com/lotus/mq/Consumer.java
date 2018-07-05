package com.lotus.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @JmsListener(destination = "test-queue-3")
    public void receiveMessage(String text){
        System.out.println("<<<<<<<======收到queue消息："+text);
    }

}
