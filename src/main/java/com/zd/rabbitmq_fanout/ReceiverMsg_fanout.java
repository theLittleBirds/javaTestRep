package com.zd.rabbitmq_fanout;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMsg_fanout {

    @RabbitListener(queues = "q_fanout_A")
    @RabbitHandler
    public void receiverA(String context){
        System.err.println("contextA:"+context);
    }

    @RabbitListener(queues = "q_fanout_B")
    @RabbitHandler
    public void receiverB(String context){
        System.err.println("contextB:"+context);
    }

    @RabbitListener(queues = "q_fanout_C")
    @RabbitHandler
    public void receiverC(String context){
        System.err.println("contextC:"+context);
    }
}

