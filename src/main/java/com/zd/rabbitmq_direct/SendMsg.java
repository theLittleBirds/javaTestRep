package com.zd.rabbitmq_direct;

/*
 *  Creat by zhoudi on 2019/3/18.
 */


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg {

    /**
     * AmqpTemplate:是一个wire-level的协议.(JMS是一个接口级别的API)
     * 这个协议的实现必须提供他们自己的客户端类库,所以模板接口的每一个实现必须依赖一个特定的客户端类库。
     * 到目前为止，仅仅存在一个实现：RabbitTemplate
     */
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /*
     * 生产者：发送消息方
     */
    public void sendMsg0(){
        String context = "hello , this message is going to queue1 !";
        System.err.println("sender:"+context);
        //向队列queue1发送消息context
        this.rabbitTemplate.convertAndSend("queue1",context);
    }

}
