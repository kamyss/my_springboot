package com.zjh.springboot.demo;

import com.zjh.springboot.demo.bean.MailProperties;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("cnn.queue");
    }

    @Bean
    public MailProperties mail(){
        return new MailProperties();
    }
}