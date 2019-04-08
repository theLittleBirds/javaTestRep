package com.zd.springcludedemo;

import com.zd.rabbitmq_direct.SendMsg;
import com.zd.rabbitmq_direct1.SendMsg1;
import com.zd.rabbitmq_fanout.SendMsg_fanout;
import com.zd.rabbitmq_header.SendMsg_header;
import com.zd.rabbitmq_topic.SendMsg_topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcludeDemoApplicationTests {

    @Autowired
    private SendMsg sendMsg0;

    @Autowired
    private SendMsg1 sendMsg1;

    @Autowired
    private SendMsg_topic sendMsgTopic;

    @Autowired
    private SendMsg_fanout sendMsgFanout;

    @Autowired
    private SendMsg_header sendMsgHeader;

    /**
     * 直连交换机：Direct
     * 当消息的routing key 与 binding 的 routing key 直接匹配，消息路由到该队列
     * @throws Exception
     */
    @Test
    public void sendDirectMQ() throws Exception{
        sendMsg0.sendMsg0();
    }

    /*@Test
    public void sendDirectMQ1() throws Exception{
        sendMsg1.sendMsg1();
    }

    *//**
     * 主题交换机：Topic
     * 当消息routing key 与 binding 的 routing key 符合通配符匹配，消息路由到该队列(
     * @throws Exception
     *//*
    @Test
    public void sendTopicMQ1() throws Exception{
        sendMsgTopic.sendMsg_Topic1();
    }

    @Test
    public void sendTopicMQ2() throws Exception{
        sendMsgTopic.sendMsg_Topic2();
    }

    *//**
     * 扇形交换机：fanout
     * 将消息发送到所有绑定到该换机的队列上
     *//*
    @Test
    public void sendFanoutMQ(){
        sendMsgFanout.sedMsg_fanout();
    }

    *//**
     * 首部交换机：header
     *//*
    @Test
    public void  sendHeaderMQ(){
        sendMsgHeader.sendMsg_header();
    }*/
}
