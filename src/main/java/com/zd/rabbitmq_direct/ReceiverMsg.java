package com.zd.rabbitmq_direct;

/*
 *  Creat by zhoudi on 2019/3/18.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue1")
public class ReceiverMsg {


    /*
     * 消费者：接受消息方
     */
    @RabbitHandler
    public void receivedMsg(String context){
        System.err.println("Receiver1-->:"+context);//输出接受到的消息
    }
}
