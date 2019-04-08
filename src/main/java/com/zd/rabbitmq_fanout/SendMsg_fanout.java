package com.zd.rabbitmq_fanout;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg_fanout {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sedMsg_fanout() {
        String context = "hello, fanout is 广播";
        System.err.println("context:"+context);
        this.amqpTemplate.convertAndSend("fanoutExchange","可要可不要",context);
    }
}
