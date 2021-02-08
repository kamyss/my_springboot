package com.zjh.springboot.demo.controller;

import com.zjh.springboot.demo.bean.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

@RestController
@RequestMapping("queue")
public class QueueController {

    @Autowired
    private Destination destination;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Environment env;

    @Autowired
    private MailProperties mailProperties;

    @RequestMapping("send/{message}")
    public String send(@PathVariable String message){
        this.jmsTemplate.convertAndSend(destination,message);
        return "消息发送成功，你发的消息是："+message;
    }

    @RequestMapping("get-config")
    public String getConfig(){
        return env.getProperty("url");
    }

    @RequestMapping("get-my-config")
    public String getMyConfig(){
        return mailProperties.getHost() + "<br>" + mailProperties.getPort() + "<br>" + mailProperties.getUsername()

                + "<br>" + mailProperties.getPassword();
    }
}
