package com.zjh.springboot.demo.bean;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    //接收消息的方法
    @JmsListener(destination="cnn.queue")
    public void readMessage(String text){
        System.out.println("接收到的消息是"+text);
    }

}
