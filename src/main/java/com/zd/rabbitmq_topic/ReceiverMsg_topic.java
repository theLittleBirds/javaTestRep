package com.zd.rabbitmq_topic;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMsg_topic {

    @RabbitListener(queues = "q_topic_message1")
    @RabbitHandler
    public void receiverMsg1(String context){
        System.err.println("receiver1:"+context);
    }

    @RabbitListener(queues = "q_topic_message2")
    @RabbitHandler
    public void receiverMsg2(String context){
        System.err.println("receiver2:"+context);
    }

}

