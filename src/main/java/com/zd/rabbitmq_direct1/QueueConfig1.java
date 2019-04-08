package com.zd.rabbitmq_direct1;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/*
 *  Creat by zhoudi on 2019/3/18.
 */

@Configuration
public class QueueConfig1 {

    /*
     *  @RabbitListener(queuesToDeclare = @Queue("queue1")) --->> 通过注解自动创建queue1队列
     *  @RabbitHandler 当监听到队列的时候，对队列里面的消息进行处理
     */
    @RabbitListener(queuesToDeclare = @Queue("queue2"))
    @RabbitHandler
    public void  received(User  user){
        System.err.println("Receiver2:"+user.toString());
    }
}
