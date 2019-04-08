package com.zd.rabbitmq_header;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg_header {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg_header(){
        String context = "hello, I am the headers Message";
        System.err.println("context:"+context);

        MessageProperties mp = new MessageProperties();
        mp.setHeader("header1","value1");
        mp.setHeader("header2","value2");

        Message message = new Message(context.getBytes(),mp);

        this.amqpTemplate.convertAndSend("headerExchange","",message);
    }
}
