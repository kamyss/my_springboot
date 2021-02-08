package com.zjh.springboot.demo;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RunAs;
import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= DemoApplication.class)
public class MessageTest {
    @Autowired
    private Destination destination;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void test(){
        System.out.println("我已经发消息了");
        this.jmsTemplate.convertAndSend(destination,"Hello ActiveMQ!");
    }
}
