package com.zd.rabbitmq_topic;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg_topic {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 向名字为exchange，key为topic.message的交换机发送消息：context
     */
    public void sendMsg_Topic1(){
        String context = "hello, I am the topic message1";
        System.err.println("context1:"+context);
        amqpTemplate.convertAndSend("exchange","topic.message",context);
    }

    /**
     * 向名字为exchange，key为topic.message的交换机发送消息：context
     */
    public void sendMsg_Topic2(){
        String context = "hello, I am the topic message2";
        System.err.println("context2:"+context);
        amqpTemplate.convertAndSend("exchange","topic.message2",context);
    }
}
