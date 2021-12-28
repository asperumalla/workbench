package org.hello.client;

import org.learn.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class DetachedClient {
    public static void main (String[] args) {
        SpringApplication.run(DetachedClient.class,args);
    }

    @Autowired
    Message message;

    @PostConstruct
    public void start(){

        System.out.println( message.greetMessage());
    }
}

//@Component
class MessageImpl implements Message{

    @Override
    public String greetMessage () {
        return "This is a local class implementation";
    }
}
