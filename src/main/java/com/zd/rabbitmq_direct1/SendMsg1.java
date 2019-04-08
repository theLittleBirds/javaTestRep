package com.zd.rabbitmq_direct1;

/*
 *  Creat by zhoudi on 2019/3/18.
 */


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /*
     * 生产者：发送消息方
     */
    public void sendMsg1(){
        User user = new User();
        user.setUserName("张三");
        user.setPassWord("123456");
        System.err.println("sender2:"+user.toString());
        //向队列queue1发送消息context
        this.rabbitTemplate.convertAndSend("queue2",user);
    }

}
