package com.zd.rabbitmq_header;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMsg_header {

    @RabbitListener(queues = "q_header")
    @RabbitHandler
    public void receiverMsg(Message message){
        System.err.println("receiver:"+message.getBody());
    }
}
